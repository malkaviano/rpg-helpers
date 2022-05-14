package com.rkss.rpg.helpers.fixtures

import com.rkss.rpg.helpers.traits._
import java.time._

final case class BasicIntChangeEvent(
    val name: GlobalNameTag,
    val current: Int,
    val previous: Int,
    val id: String,
    val target: BasicIntTarget
) {
  val dateTime = ZonedDateTime.now(ZoneId.of("UTC")).toString
}
