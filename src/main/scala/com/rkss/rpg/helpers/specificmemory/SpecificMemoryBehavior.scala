package com.rkss.rpg.helpers.specificmemory

import scala.collection.mutable.{Map => MutableMap}

import com.rkss.rpg.helpers._

final class SpecificMemoryBehavior[A <: { def name: GlobalNameTag }] {
  import scala.language.reflectiveCalls

  private val currentMemory = MutableMap.empty[GlobalNameTag, A]

  private val amnesiaMemory = MutableMap.empty[GlobalNameTag, A]

  def acknowledge(
      fact: A
  ): Option[A] = {
    val name = fact.name

    val drop = currentMemory.get(name)

    currentMemory.addOne(name -> fact)

    amnesiaMemory.remove(name)

    drop
  }

  def remember(
      name: GlobalNameTag,
      amnesia: Boolean = false
  ): Option[A] = {
    currentMemory.get(name) match {
      case None if amnesia =>
        amnesiaMemory.get(name) match {
          case Some(value) =>
            acknowledge(value)

            Some(value)
          case None => None
        }
      case Some(value) => Some(value)
      case _           => None
    }
  }

  def forget(name: GlobalNameTag, amnesia: Boolean = false): Option[A] = {
    val forgot = currentMemory.remove(name)

    if (amnesia) {
      forgot.foreach(state => amnesiaMemory.addOne(name -> state))
    }

    forgot
  }

  def wipe(amnesia: Boolean = false): Seq[A] = {
    val removed = currentMemory.values.toSeq

    currentMemory.clear()

    if (amnesia) {
      removed.foreach(state => amnesiaMemory.addOne(state.name -> state))
    }

    removed
  }
}
