package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class HundredSidedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("HundredSided Dice") {
    val rollD100 = mockFunction[DiceRange, Int]

    val dice = HundredSidedDice(rollD100)

    val name = "D100"
    val range = HundredSidedDice.range

    behavesLikeDice(dice, name, range, rollD100, 87)

    it(s"should have range (1, 100)") {
      HundredSidedDice.range shouldBe (DiceRange(1, 100))
    }
  }
}