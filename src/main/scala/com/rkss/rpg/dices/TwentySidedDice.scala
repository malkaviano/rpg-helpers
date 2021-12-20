package com.rkss.rpg.dices

import com.rkss.rpg.traits._
import com.rkss.rpg.dices.implementation._

final case class TwentySidedDice(rng: (DiceRange) => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 20), TwentySidedDiceName)