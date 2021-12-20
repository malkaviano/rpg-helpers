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
    val range = DiceRange(1, 8)

    behavesLikeDice(dice, name, range, rollD8, 5)
  }
}