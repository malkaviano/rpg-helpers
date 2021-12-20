package com.rkss.rpg.dices

import com.rkss.rpg.traits._

abstract class AbstractDice private[dices](
    private val rng: DiceRange => DiceResult,
    private val range: DiceRange,
    override val name: DiceName
) extends Dice {
  override def roll: DiceResult = rng(range)
}
