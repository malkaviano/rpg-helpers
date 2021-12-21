package com.rkss.rpg.dice

import com.rkss.rpg.traits._
import com.rkss.rpg.dice.implementation._

final case class SixSidedDice(rng: (DiceRange) => DiceResult)
    extends AbstractDice(rng, SimpleDiceRange(1, 6), SixSidedDiceName)