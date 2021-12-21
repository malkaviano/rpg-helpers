package com.rkss.rpg.helpers.dice.imaginary

import com.rkss.rpg.helpers.dice.implementation._
import com.rkss.rpg.helpers.traits._

final case class ThreeSidedDice(rng: DiceRange => DiceResult)
    extends AbstractDice(rng, SimpleDiceRange(1, 3), ThreeSidedDiceName)