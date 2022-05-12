package com.rkss.rpg.helpers.fixtures

import com.rkss.rpg.helpers.traits._

final case class BasicIntLog(
    val name: GlobalNameTag,
    val current: Int,
    val previous: Int,
    val operation: BasicIntOperation,
    val id: String
)
