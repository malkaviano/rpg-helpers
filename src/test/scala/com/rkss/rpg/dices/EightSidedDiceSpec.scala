package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class EightSidedDiceSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Eight sided dice") {
    val rollD8 = mockFunction[DiceRange, Int]

    val dice = EightSidedDice(rollD8)

    val name = "D8"
    val range = EightSidedDice.range

    behavesLikeDice(dice, name, range, rollD8, 5)

    it(s"should have range (1, 8)") {
      EightSidedDice.range shouldBe (DiceRange(1, 8))
    }
  }
}