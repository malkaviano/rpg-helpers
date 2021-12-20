package com.rkss.rpg.dices

import com.rkss.rpg.traits.Dice
import com.rkss.rpg.traits.DiceName
import com.rkss.rpg.traits.EightSidedDiceName

final case class EightSidedDice(private val rng: DiceRange => Int) extends Dice {
  override def name: DiceName = EightSidedDiceName

  override def roll: Int = rng(DiceRange(1, 8))
}
