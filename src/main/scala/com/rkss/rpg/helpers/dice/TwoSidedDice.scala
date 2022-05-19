package com.rkss.rpg.helpers.dice

import com.rkss.rpg.helpers.dice.implementation._
import com.rkss.rpg.helpers.traits._

final case class TwoSidedDice(
    override protected val rng: DiceRange => DiceResult
) extends AbstractDice(rng, SimpleDiceRange(1, 2), TwoSidedDiceName)
