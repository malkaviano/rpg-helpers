package com.rkss.rpg.helpers.basicint

import com.rkss.rpg.helpers._

final case class BasicIntValue[A <: GlobalNameTag](
    val name: A,
    val value: Int
)
