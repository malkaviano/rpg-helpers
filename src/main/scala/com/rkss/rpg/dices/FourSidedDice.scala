package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class FourSidedDice(private val rng: DiceRange => Int) extends Dice {
  override def name: DiceName = FourSidedDiceName

  override def roll: Int = rng(DiceRange(1, 4))
}