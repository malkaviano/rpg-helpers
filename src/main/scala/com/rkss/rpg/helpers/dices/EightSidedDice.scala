package com.rkss.rpg.helpers.dices

import com.rkss.rpg.traits.Dice

final case class EightSidedDice(private val rollD4: DiceRange => Int) extends Dice {
  override def name: String = "D8"

  override def roll: Int = rollD4(EightSidedDice.range)
}

object EightSidedDice {
  val range: DiceRange = DiceRange(1, 8)
}