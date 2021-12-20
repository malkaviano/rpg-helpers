package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class TenSidedDice(rollD10: (DiceRange) => Int) extends Dice {
  override val name: DiceName = TenSidedDiceName

  override def roll: Int = rollD10(TenSidedDice.range)
}

object TenSidedDice {
  val range: DiceRange = DiceRange(1, 10)
}