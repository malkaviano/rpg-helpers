package com.rkss.rpg.helpers.fixtures

import com.rkss.rpg.helpers.traits._

final case class BasicIntValue[A <: GlobalNameTag](
    val name: A,
    val value: Int
)
