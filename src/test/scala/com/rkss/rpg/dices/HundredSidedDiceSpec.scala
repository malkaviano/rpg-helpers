package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class HundredSidedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Hundred sided dice") {
    val rollD100 = mockFunction[DiceRange, Int]

    val dice = HundredSidedDice(rollD100)

    val name = "D100"
    val range = DiceRange(1, 100)

    behavesLikeDice(dice, name, range, rollD100, 87)
  }
}