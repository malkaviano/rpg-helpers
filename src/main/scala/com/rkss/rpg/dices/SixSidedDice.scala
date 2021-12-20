package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class SixSidedDice(rng: (DiceRange) => Int)
    extends AbstractDice(rng, DiceRange(1, 6), SixSidedDiceName)