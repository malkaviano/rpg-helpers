package com.rkss.rpg.dice.implementation

import com.rkss.rpg.traits._

abstract class AbstractDice private[dice] (
    private val rng: DiceRange => DiceResult,
    private val range: DiceRange,
    override val name: DiceName
) extends Dice {
  override def roll: DiceResult = rng(range)
}
