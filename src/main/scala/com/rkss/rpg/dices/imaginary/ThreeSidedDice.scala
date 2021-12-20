package com.rkss.rpg.dices.imaginary

import com.rkss.rpg.dices.implementation._
import com.rkss.rpg.traits._

final case class ThreeSidedDice(rng: DiceRange => DiceResult)
    extends AbstractDice(rng, DiceRange(1, 3), ThreeSidedDiceName)