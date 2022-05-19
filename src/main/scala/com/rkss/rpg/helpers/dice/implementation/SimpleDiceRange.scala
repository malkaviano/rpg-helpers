package com.rkss.rpg.helpers.dice.implementation

import com.rkss.rpg.helpers.dice._

final case class SimpleDiceRange private[dice] (
    override val min: Int,
    override val max: Int
) extends DiceRange
