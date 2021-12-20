package com.rkss.rpg.dices

import com.rkss.rpg.traits._

final case class SixSidedDice(rollD6: (DiceRange) => Int) extends Dice {
  override val name: DiceName = SixSidedDiceName

  override def roll: Int = rollD6(SixSidedDice.range)
}

object SixSidedDice {
  val range: DiceRange = DiceRange(1, 6)
}