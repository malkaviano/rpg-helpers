package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class HundredSidedDice(rng: (DiceRange) => Int)
    extends AbstractDice(rng, DiceRange(1, 100), HundredSidedDiceName)