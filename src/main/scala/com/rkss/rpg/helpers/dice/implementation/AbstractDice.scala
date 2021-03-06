package com.rkss.rpg.helpers.dice.implementation

import com.rkss.rpg.helpers.dice._

abstract class AbstractDice private[dice] (
    protected val rng: DiceRange => DiceResult,
    private val range: DiceRange,
    override val name: DiceName
) extends Dice {
  override def roll: DiceResult = rng(range)
}
