package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class TenSidedDice(rng: (DiceRange) => Int) extends Dice {
  override val name: DiceName = TenSidedDiceName

  override def roll: Int = rng(DiceRange(1, 10))
}