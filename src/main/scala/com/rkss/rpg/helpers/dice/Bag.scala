package com.rkss.rpg.helpers.dice

import scala.util.Random

import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.helpers.dice.implementation._

object Bag {
  implicit val fourSidedDice = FourSidedDice(rangeDice)

  implicit val sixSidedDice = SixSidedDice(rangeDice)

  implicit val eightSidedDice = EightSidedDice(rangeDice)

  implicit val tenSidedDice = TenSidedDice(rangeDice)

  implicit val twelveSidedDice = TwelveSidedDice(rangeDice)

  implicit val twentySidedDice = TwentySidedDice(rangeDice)

  implicit val hundredSidedDice = HundredSidedDice(rangeDice)

  implicit val twoSidedDice = TwoSidedDice(rangeDice)

  implicit val threeSidedDice = ThreeSidedDice(rangeDice)

  private def rangeDice(range: DiceRange): DiceResult = {
    SimpleDiceResult(Random.between(range.min, range.max + 1))
  }
}
