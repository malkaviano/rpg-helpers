package com.rkss.rpg.dices

import com.rkss.rpg.traits.Dice

final case class TenSidedDice(rollD10: (DiceRange) => Int) extends Dice {
  override val name: String = "D10"

  override def roll: Int = rollD10(TenSidedDice.range)
}

object TenSidedDice {
  val range: DiceRange = DiceRange(1, 10)
}