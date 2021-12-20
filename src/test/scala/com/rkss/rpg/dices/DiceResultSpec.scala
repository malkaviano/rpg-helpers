package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DiceResultSpec extends AnyFunSpec with Matchers {
  describe("Dice Result comparison") {
    val diceResult1 = SimpleDiceResult(10)
    val diceResult2 = SimpleDiceResult(20)
    val diceResult3 = SimpleDiceResult(20)

    describe(s"when ${diceResult1} < ${diceResult2}") {
      test(diceResult1 < diceResult2)
    }

    describe(s"when ${diceResult2} > ${diceResult1}") {
      test(diceResult2 > diceResult1)
    }

    describe(s"when ${diceResult2} <= ${diceResult3}") {
      test(diceResult2 <= diceResult3)
    }

    describe(s"when ${diceResult3} >= ${diceResult1}") {
      test(diceResult3 >= diceResult1)
    }

    describe(s"when ${diceResult2} == ${diceResult3}") {
      test(diceResult2 == diceResult3)
    }
  }

  private def test(fn: => Boolean): Unit = {
    it("should be true") {
      fn shouldBe true
    }
  }
}
