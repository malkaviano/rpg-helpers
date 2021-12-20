package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class FourSidedDiceSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Four sided dice") {
    val rollD4 = mockFunction[DiceRange, Int]

    val dice = FourSidedDice(rollD4)

    val name = "D4"
    val range = DiceRange(1, 4)

    behavesLikeDice(dice, name, range, rollD4, 2)
  }
}
