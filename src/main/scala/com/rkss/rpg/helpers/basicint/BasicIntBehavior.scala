package com.rkss.rpg.helpers.basicint

import com.rkss.rpg.helpers.GlobalNameTag

trait BasicIntBehavior[A <: GlobalNameTag] {
  def value: Int

  def minimum: Int

  def minimum_=(v: Int): Unit

  def maximum: Int

  def maximum_=(v: Int): Unit

  def plus(other: BasicIntValue[A]): Unit

  def minus(other: BasicIntValue[A]): Unit

  def multiply(other: BasicIntValue[A]): Unit

  def div(other: BasicIntValue[A]): Unit

  def onValueChanged(f: (Int, Int) => Unit): Unit

  def clearOnValueChanged(): Unit
}

object BasicIntBehavior {
  def apply[A <: GlobalNameTag](
      name: A,
      options: BasicIntOptions = BasicIntOptions()
  ): BasicIntBehavior[A] = {
    BasicIntBehaviorImpl(name, options)
  }

  def apply[A <: GlobalNameTag](
      name: A,
      options: BasicIntDynamicOptions
  ): BasicIntBehavior[A] = {
    BasicIntDynamicBehaviorImpl(name, options)
  }
}
