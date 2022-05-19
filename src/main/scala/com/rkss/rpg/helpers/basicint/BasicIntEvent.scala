package com.rkss.rpg.helpers.basicint

import com.rkss.rpg.helpers.traits._
import java.time._

final case class BasicIntEvent(
    val name: GlobalNameTag,
    val current: Int,
    val previous: Int,
    val id: String,
    val target: BasicIntTarget
) {
  val dateTime = ZonedDateTime.now(ZoneId.of("UTC")).toString
}
