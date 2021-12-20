package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DiceResultSpec extends AnyFunSpec with Matchers {
  describe("Dice Result compare") {
    val diceResult1 = SimpleDiceResult(10)
    val diceResult2 = SimpleDiceResult(20)

    describe(s"when ${diceResult1} compare ${diceResult2}") {
      it("should return -1") {
        val result = diceResult1.compare(diceResult2)

        result shouldBe -1
      }
    }

    describe(s"when ${diceResult2} compare ${diceResult1}") {
      it("should return 1") {
        val result = diceResult2.compare(diceResult1)

        result shouldBe 1
      }
    }

    describe(s"when ${diceResult2} compare ${diceResult2}") {
      it("should return 0") {
        val result = diceResult2.compare(diceResult2)

        result shouldBe 0
      }
    }
  }
}
