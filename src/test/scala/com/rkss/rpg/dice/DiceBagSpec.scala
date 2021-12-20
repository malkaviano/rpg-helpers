package com.rkss.rpg.dice

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable.{Set => MutableSet}

import com.rkss.rpg.traits._

class DiceBagSpec extends AnyFunSpec with Matchers {
  describe("fourSidedDice") {
    test(DiceBag.fourSidedDice, 4, 40)
  }

  describe("sixSidedDice") {
    test(DiceBag.sixSidedDice, 6, 60)
  }

  describe("eightSidedDice") {
    test(DiceBag.eightSidedDice, 8, 80)
  }

  describe("tenSidedDice") {
    test(DiceBag.tenSidedDice, 10, 100)
  }

  describe("twelveSidedDice") {
    test(DiceBag.twelveSidedDice, 12, 120)
  }

  describe("twentySidedDice") {
    test(DiceBag.twentySidedDice, 20, 200)
  }

  describe("hundredSidedDice") {
    test(DiceBag.hundredSidedDice, 100, 1000)
  }

  describe("twoSidedDice") {
    test(DiceBag.twoSidedDice, 2, 20)
  }

  describe("threeSidedDice") {
    test(DiceBag.threeSidedDice, 3, 30)
  }

  private def test(obj: Dice, expected: Int, runs: Int) = {
    val resultSet = MutableSet.empty[DiceResult]

    (1 to runs).foreach(_ => resultSet.add(obj.roll))

    it(s"should generate ${expected} unique results") {
      resultSet.size shouldBe expected
    }
  }
}
