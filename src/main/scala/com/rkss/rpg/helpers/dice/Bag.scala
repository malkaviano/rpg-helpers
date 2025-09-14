package com.rkss.rpg.helpers.dice

import scala.util.Random

import com.rkss.rpg.helpers.dice.implementation._

object Bag {
  implicit val fourSidedDice: FourSidedDice = FourSidedDice(rangeDice)

  implicit val sixSidedDice: SixSidedDice = SixSidedDice(rangeDice)

  implicit val eightSidedDice: EightSidedDice = EightSidedDice(rangeDice)

  implicit val tenSidedDice: TenSidedDice = TenSidedDice(rangeDice)

  implicit val twelveSidedDice: TwelveSidedDice = TwelveSidedDice(rangeDice)

  implicit val twentySidedDice: TwentySidedDice = TwentySidedDice(rangeDice)

  implicit val hundredSidedDice: HundredSidedDice = HundredSidedDice(rangeDice)

  implicit val twoSidedDice: TwoSidedDice = TwoSidedDice(rangeDice)

  implicit val threeSidedDice: ThreeSidedDice = ThreeSidedDice(rangeDice)

  private def rangeDice(range: DiceRange): DiceResult = {
    SimpleDiceResult(Random.between(range.min, range.max + 1))
  }
}
