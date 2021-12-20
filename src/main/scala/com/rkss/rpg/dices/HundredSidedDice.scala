package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class HundredSidedDice(rollD100: (DiceRange) => Int) extends Dice {
  override val name: DiceName = HundredSidedDiceName

  override def roll: Int = rollD100(HundredSidedDice.range)
}

object HundredSidedDice {
  val range: DiceRange = DiceRange(1, 100)
}