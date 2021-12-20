package com.rkss.rpg.dices

import com.rkss.rpg.traits.DiceResult

final case class SimpleDiceResult private[dices] (override val value: Int)
    extends DiceResult
