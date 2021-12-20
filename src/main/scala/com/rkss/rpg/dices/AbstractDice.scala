package com.rkss.rpg.dices

import com.rkss.rpg.traits.Dice
import com.rkss.rpg.traits.DiceName

abstract class AbstractDice(
    private val rng: DiceRange => Int,
    private val range: DiceRange,
    override val name: DiceName
) extends Dice {
  override def roll: Int = rng(range)
}
