package com.rkss.rpg.dices.imaginary

import com.rkss.rpg.dices.implementation._
import com.rkss.rpg.traits._

final case class TwoSidedDice(rng: DiceRange => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 2), TwoSidedDiceName)