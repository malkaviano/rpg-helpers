package com.rkss.rpg.helpers.basicint

final case class BasicIntDynamicOptions(
    val source: () => Int,
    private val minimum: Int = Int.MinValue,
    private val maximum: Int = Int.MaxValue,
    val roundUp: Boolean = false
) {
  def minimumValue: Int = if (minimum > source()) source() else minimum

  def maximumValue: Int = if (maximum < source()) source() else maximum
}
