package com.rkss.rpg.helpers.fixtures

final case class BasicIntOptions(
    val initial: Int = 0,
    private val minimum: Int = Int.MinValue,
    private val maximum: Int = Int.MaxValue,
    val roundUp: Boolean = false,
    val equalizeOnValueInferiorMinimum: Boolean = false,
    val equalizeOnValueSuperiorMaximum: Boolean = false,
    val id: String = java.util.UUID.randomUUID.toString
) {
  def minimumValue: Int = if (minimum > initial) initial else minimum

  def maximumValue: Int = if (maximum < initial) initial else maximum
}
