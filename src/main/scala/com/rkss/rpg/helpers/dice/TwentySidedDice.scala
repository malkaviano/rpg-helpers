package com.rkss.rpg.helpers.dice

import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.helpers.dice.implementation._

final case class TwentySidedDice(override protected val rng: DiceRange => DiceResult)
    extends AbstractDice(rng, SimpleDiceRange(1, 20), TwentySidedDiceName)