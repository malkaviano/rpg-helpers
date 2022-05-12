package com.rkss.rpg.helpers.fixtures

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.traits._

final case class BasicIntFixture[A <: GlobalNameTag](
    val name: A,
    val initial: Int = 0,
    val minimum: Int = Int.MinValue,
    val maximum: Int = Int.MaxValue,
    val roundUp: Boolean = false
) {
  private var current = initial

  private val logs = MutableQueue.empty[BasicIntLog[A]]

  def value: Int = current

  def plus(other: BasicIntValue[A]): Unit = {
    operate(other, BasicIntOperationPlus)
  }

  def minus(other: BasicIntValue[A]): Unit = {
    operate(other, BasicIntOperationMinus)
  }

  def multiply(other: BasicIntValue[A]): Unit = {
    operate(other, BasicIntOperationMultiply)
  }

  def div(other: BasicIntValue[A]): Unit = {
    operate(other, BasicIntOperationDiv)
  }

  def history: List[BasicIntLog[A]] = logs.toList

  private def operate(other: BasicIntValue[A], op: BasicIntOperation) = {
    val old = current

    op match {
      case BasicIntOperationDiv =>
        current /= other.value

        if (roundUp && Math.abs(current % other.value) > 0) current += 1
      case BasicIntOperationMinus =>
        current -= other.value
      case BasicIntOperationMultiply =>
        current *= other.value
      case BasicIntOperationPlus =>
        current += other.value
    }

    enforceLimits()

    log(old, op)
  }

  private def enforceLimits(): Unit = {
    if (current > maximum) current = maximum

    if (current < minimum) current = minimum
  }

  private def log(previous: Int, op: BasicIntOperation) = {
    logs.enqueue(BasicIntLog(name, current, previous, op))
  }
}
