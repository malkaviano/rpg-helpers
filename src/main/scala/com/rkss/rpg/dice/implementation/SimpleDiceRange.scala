package com.rkss.rpg.dice.implementation

import com.rkss.rpg.traits.DiceRange

final case class SimpleDiceRange private[dice] (
    override val min: Int,
    override val max: Int
) extends DiceRange
