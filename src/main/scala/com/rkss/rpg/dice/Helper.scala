package com.rkss.rpg.dice

import scala.util.Random

import com.rkss.rpg.traits._
import com.rkss.rpg.dice.implementation._
import com.rkss.rpg.dice.imaginary._

object Helper {
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
