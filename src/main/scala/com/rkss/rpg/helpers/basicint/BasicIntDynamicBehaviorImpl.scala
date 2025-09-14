package com.rkss.rpg.helpers.basicint

import com.rkss.rpg.helpers._

final case class BasicIntDynamicBehaviorImpl[A <: GlobalNameTag](
    val name: A,
    val options: BasicIntDynamicOptions
) extends BasicIntBehavior[A] {
  private var _extra: Seq[(Int) => Int] = Seq.empty

  private var _maximum = options.maximumValue

  private var _minimum = options.minimumValue

  private var valueChangedDelegate: Option[(Int, Int) => Unit] = None

  val roundUp = options.roundUp

  def value: Int = {
    println(_extra)

    val proposed =
      _extra.foldLeft(options.source())((acc, f) => f(acc))

    if (proposed > maximum) maximum
    else if (proposed < minimum) minimum
    else proposed
  }

  def minimum: Int = _minimum

  def minimum_=(v: Int): Unit = {
    if (v <= maximum) {
      _minimum = v
    }
  }

  def maximum: Int = _maximum

  def maximum_=(v: Int): Unit = {
    if (v >= minimum) {
      _maximum = v
    }
  }

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

  def onValueChanged(f: (Int, Int) => Unit): Unit = {
    valueChangedDelegate = Some(f)
  }

  def clearOnValueChanged(): Unit = {
    valueChangedDelegate = None
  }

  private def operate(other: BasicIntValue[A], op: BasicIntOperation) = {
    val old = value

    op match {
      case BasicIntOperationDiv =>
        val div = (x: Int) => {
          var targetValue = x / other.value

          if (roundUp && (x % other.value) != 0) targetValue += 1

          targetValue
        }

        _extra = _extra :+ div
      case BasicIntOperationMinus =>
        val minus = (x: Int) => x - other.value

        _extra = _extra :+ minus
      case BasicIntOperationMultiply =>
        val multiply = (x: Int) => x * other.value

        _extra = _extra :+ multiply
      case BasicIntOperationPlus =>
        val plus = (x: Int) => x + other.value

        _extra = _extra :+ plus
    }

    valueChangedDelegate map { f =>
      if (old != value)
        f(old, value)
    }
  }
}
