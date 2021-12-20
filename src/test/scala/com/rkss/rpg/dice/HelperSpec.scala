package com.rkss.rpg.dice

import org.scalatest.funspec.AnyFunSpec

import scala.collection.mutable.{Set => MutableSet}
import com.rkss.rpg.traits.DiceResult
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.traits.Dice

class HelperSpec extends AnyFunSpec with Matchers {
  describe("fourSidedDice") {
    test(Helper.fourSidedDice, 4, 40)
  }

  describe("sixSidedDice") {
    test(Helper.sixSidedDice, 6, 60)
  }

  describe("eightSidedDice") {
    test(Helper.eightSidedDice, 8, 80)
  }

  describe("tenSidedDice") {
    test(Helper.tenSidedDice, 10, 100)
  }

  describe("twelveSidedDice") {
    test(Helper.twelveSidedDice, 12, 120)
  }

  describe("twentySidedDice") {
    test(Helper.twentySidedDice, 20, 200)
  }

  describe("hundredSidedDice") {
    test(Helper.hundredSidedDice, 100, 1000)
  }

  describe("twoSidedDice") {
    test(Helper.twoSidedDice, 2, 20)
  }

  describe("threeSidedDice") {
    test(Helper.threeSidedDice, 3, 30)
  }

  private def test(obj: Dice, expected: Int, runs: Int) = {
    val resultSet = MutableSet.empty[DiceResult]

    (1 to runs).foreach(_ => resultSet.add(obj.roll))

    it(s"should generate ${expected} unique results") {
      resultSet.size shouldBe expected
    }
  }
}
