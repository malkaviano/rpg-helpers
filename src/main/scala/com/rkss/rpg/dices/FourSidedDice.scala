package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class FourSidedDice(rng: DiceRange => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 4), FourSidedDiceName)