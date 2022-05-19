package com.rkss.rpg.helpers.dice

import com.rkss.rpg.helpers.dice.implementation._

final case class FourSidedDice(
    override protected val rng: DiceRange => DiceResult
) extends AbstractDice(rng, SimpleDiceRange(1, 4), FourSidedDiceName)
