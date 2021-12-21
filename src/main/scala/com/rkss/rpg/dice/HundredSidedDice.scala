package com.rkss.rpg.dice

import com.rkss.rpg.traits._
import com.rkss.rpg.dice.implementation._

final case class HundredSidedDice(rng: (DiceRange) => DiceResult)
    extends AbstractDice(rng, SimpleDiceRange(1, 100), HundredSidedDiceName)