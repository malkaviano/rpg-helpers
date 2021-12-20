package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class SixSidedDiceSpec extends AnyFunSpec with Matchers with MockFactory with BehavesLikeDice {
  describe("Six sided dice") {
    val rollD6 = mockFunction[DiceRange, Int]

    val dice = SixSidedDice(rollD6)

    val name = "D6"
    val range = DiceRange(1, 6)

    behavesLikeDice(dice, name, range, rollD6, 5)
  }
}
