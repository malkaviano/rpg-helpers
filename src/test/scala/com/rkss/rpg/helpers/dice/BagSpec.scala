package com.rkss.rpg.helpers.dice

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable.{Set => MutableSet}

class BagSpec extends AnyFunSpec with Matchers {
  describe("fourSidedDice") {
    test(Bag.fourSidedDice, 4, 40)
  }

  describe("sixSidedDice") {
    test(Bag.sixSidedDice, 6, 60)
  }

  describe("eightSidedDice") {
    test(Bag.eightSidedDice, 8, 80)
  }

  describe("tenSidedDice") {
    test(Bag.tenSidedDice, 10, 100)
  }

  describe("twelveSidedDice") {
    test(Bag.twelveSidedDice, 12, 120)
  }

  describe("twentySidedDice") {
    test(Bag.twentySidedDice, 20, 200)
  }

  describe("hundredSidedDice") {
    test(Bag.hundredSidedDice, 100, 1000)
  }

  describe("twoSidedDice") {
    test(Bag.twoSidedDice, 2, 20)
  }

  describe("threeSidedDice") {
    test(Bag.threeSidedDice, 3, 30)
  }

  private def test(obj: Dice, expected: Int, runs: Int) = {
    val resultSet = MutableSet.empty[DiceResult]

    (1 to runs).foreach(_ => resultSet.add(obj.roll))

    it(s"should generate ${expected} unique results") {
      resultSet.size shouldBe expected
    }
  }
}
