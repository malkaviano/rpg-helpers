package com.rkss.rpg.dices

import com.rkss.rpg.traits.EightSidedDiceName

final case class EightSidedDice(rng: DiceRange => Int)
    extends AbstractDice(rng, DiceRange(1, 8), EightSidedDiceName)