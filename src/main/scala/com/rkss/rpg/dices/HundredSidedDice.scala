package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class HundredSidedDice(rng: (DiceRange) => Int) extends Dice {
  override val name: DiceName = HundredSidedDiceName

  override def roll: Int = rng(DiceRange(1, 100))
}