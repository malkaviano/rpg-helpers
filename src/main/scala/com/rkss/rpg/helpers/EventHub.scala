package com.rkss.rpg.helpers

import scala.collection.mutable.{Map => MutableMap}

import com.rkss.rpg.helpers.basicint._

case object EventHub {
  private val basicIntEventListeners =
    MutableMap.empty[(String, String), (BasicIntEvent) => Unit]

  def shout(id: String, event: BasicIntEvent): Unit = {
    basicIntEventListeners.foreach { case ((producerId, _), func) =>
      if (id == producerId) func.apply(event)
    }
  }

  def addListener(
      producerId: String,
      listenerId: String,
      func: (BasicIntEvent) => Unit
  ): Unit = {
    basicIntEventListeners.addOne(((producerId, listenerId), func))
  }

  def removeListener(producerId: String, listenerId: String): Unit = {
    basicIntEventListeners.remove((producerId, listenerId))
  }
}
