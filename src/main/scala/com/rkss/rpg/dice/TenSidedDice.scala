package com.rkss.rpg.dice

import com.rkss.rpg.traits._
import com.rkss.rpg.dice.implementation._

final case class TenSidedDice(rng: (DiceRange) => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 10), TenSidedDiceName)