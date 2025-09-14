package com.rkss.rpg.helpers.basicint

import com.rkss.rpg.helpers._

final case class BasicIntBehavior[A <: GlobalNameTag](
    val name: A,
    val options: BasicIntOptions = BasicIntOptions()
) {
  private var _value = options.initial
  private var _maximum = options.maximumValue
  private var _minimum = options.minimumValue

  val equalizeOnValueInferiorMinimum = options.equalizeOnValueInferiorMinimum
  val equalizeOnValueSuperiorMaximum = options.equalizeOnValueSuperiorMaximum
  val roundUp = options.roundUp

  def value: Int = _value

  def minimum: Int = _minimum

  def minimum_=(v: Int): Unit = {
    if (v <= maximum) {
      _minimum = v

      if (equalizeOnValueInferiorMinimum && value < _minimum) {

        _value = _minimum
      }
    }
  }

  def maximum: Int = _maximum

  def maximum_=(v: Int): Unit = {
    if (v >= minimum) {
      _maximum = v

      if (equalizeOnValueSuperiorMaximum && value > _maximum) {

        _value = _maximum
      }
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

  private def operate(other: BasicIntValue[A], op: BasicIntOperation) = {
    op match {
      case BasicIntOperationDiv =>
        _value /= other.value

        if (roundUp && Math.abs(_value % other.value) > 0) _value += 1
      case BasicIntOperationMinus =>
        _value -= other.value
      case BasicIntOperationMultiply =>
        _value *= other.value
      case BasicIntOperationPlus =>
        _value += other.value
    }

    enforceLimits()
  }

  private def enforceLimits(): Unit = {
    if (value > maximum) _value = maximum

    if (value < minimum) _value = minimum
  }
}
