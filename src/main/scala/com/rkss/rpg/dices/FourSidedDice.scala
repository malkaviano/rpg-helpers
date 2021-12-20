package com.rkss.rpg.dices

import com.rkss.rpg.traits.Dice

final case class FourSidedDice(private val rollD4: DiceRange => Int) extends Dice {
  override def name: String = "D4"

  override def roll: Int = rollD4(FourSidedDice.range)
}

object FourSidedDice {
  val range: DiceRange = DiceRange(1, 4)
}