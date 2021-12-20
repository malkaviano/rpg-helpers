package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class TenSidedDice(rng: (DiceRange) => Int)
    extends AbstractDice(rng, DiceRange(1, 10), TenSidedDiceName)