package com.rkss.rpg.helpers.fixtures

import scala.collection.mutable.{Queue => MutableQueue, Map => MutableMap}

import com.rkss.rpg.helpers.traits._

final case class BasicIntFixture[A <: GlobalNameTag](
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

  private val events = MutableQueue.empty[BasicIntChangeEvent]

  private val changeListeners =
    MutableMap.empty[String, (BasicIntChangeEvent) => Unit]

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

  def history: List[BasicIntChangeEvent] = events.toList

  def addChangeListener(func: (BasicIntChangeEvent) => Unit): String = {
    val id = java.util.UUID.randomUUID.toString

    changeListeners.addOne((id, func))

    id
  }

  def removeChangeListener(id: String): Unit = {
    changeListeners.remove(id)
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
    val event = BasicIntChangeEvent(name, current, previous, id, target)

    events.enqueue(event)

    changeListeners.values.foreach(_.apply(event))
  }
}
