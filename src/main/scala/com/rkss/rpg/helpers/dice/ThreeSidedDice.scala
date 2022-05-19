package com.rkss.rpg.helpers.dice

import com.rkss.rpg.helpers.dice.implementation._
import com.rkss.rpg.helpers.traits._

final case class ThreeSidedDice(
    override protected val rng: DiceRange => DiceResult
) extends AbstractDice(rng, SimpleDiceRange(1, 3), ThreeSidedDiceName)
