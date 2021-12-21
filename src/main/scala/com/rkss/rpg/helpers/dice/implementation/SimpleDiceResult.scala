package com.rkss.rpg.helpers.dice.implementation

import com.rkss.rpg.helpers.traits.DiceResult

final case class SimpleDiceResult private[dice] (override val value: Int)
    extends DiceResult
