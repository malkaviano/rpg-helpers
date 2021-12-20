package com.rkss.rpg.dice.implementation

import com.rkss.rpg.traits.DiceResult

final case class SimpleDiceResult private[dice] (override val value: Int)
    extends DiceResult
