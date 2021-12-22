package com.rkss.rpg.helpers.dice

import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.helpers.dice.implementation._

final case class SixSidedDice(override protected val rng: DiceRange => DiceResult)
    extends AbstractDice(rng, SimpleDiceRange(1, 6), SixSidedDiceName)