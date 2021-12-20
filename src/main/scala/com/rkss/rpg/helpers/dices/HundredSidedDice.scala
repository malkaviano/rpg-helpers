package com.rkss.rpg.helpers.dices

import com.rkss.rpg.traits.Dice

final case class HundredSidedDice(rollD100: (DiceRange) => Int) extends Dice {
  override val name: String = "D100"

  override def roll: Int = rollD100(HundredSidedDice.range)
}

object HundredSidedDice {
  val range: DiceRange = DiceRange(1, 100)
}