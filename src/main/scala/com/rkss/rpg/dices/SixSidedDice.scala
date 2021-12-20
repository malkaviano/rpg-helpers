package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class SixSidedDice(rng: (DiceRange) => Int) extends Dice {
  override val name: DiceName = SixSidedDiceName

  override def roll: Int = rng(DiceRange(1, 6))
}