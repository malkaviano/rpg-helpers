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
  val id = options.id

  def value: Int = _value

  def minimum: Int = _minimum

  def minimum_=(v: Int): Unit = {
    if (v <= maximum) {
      log(_minimum, v, BasicIntTargetMinimum)

      _minimum = v

      if (equalizeOnValueInferiorMinimum && value < _minimum) {
        log(_value, _minimum, BasicIntTargetValue)

        _value = _minimum
      }
    }
  }

  def maximum: Int = _maximum

  def maximum_=(v: Int): Unit = {
    if (v >= minimum) {
      log(_maximum, v, BasicIntTargetMaximum)

      _maximum = v

      if (equalizeOnValueSuperiorMaximum && value > _maximum) {
        log(_value, _maximum, BasicIntTargetValue)

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
    val old = _value

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

    log(old, value, BasicIntTargetValue)
  }

  private def enforceLimits(): Unit = {
    if (value > maximum) _value = maximum

    if (value < minimum) _value = minimum
  }

  private def log(
      previous: Int,
      current: Int,
      target: BasicIntTarget
  ): Unit = {
    val event = BasicIntEvent(name, current, previous, id, target)

    EventHub.shout(event)
  }
}
