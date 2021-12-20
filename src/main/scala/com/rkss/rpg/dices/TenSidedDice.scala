package com.rkss.rpg.dices

import com.rkss.rpg.traits._
import com.rkss.rpg.dices.implementation._

final case class TenSidedDice(rng: (DiceRange) => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 10), TenSidedDiceName)