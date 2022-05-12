package com.rkss.rpg.helpers.fixtures

import com.rkss.rpg.helpers.traits._

final case class BasicIntLog[A <: GlobalNameTag](
    val name: A,
    val current: Int,
    val previous: Int,
    val operation: BasicIntOperation
)
