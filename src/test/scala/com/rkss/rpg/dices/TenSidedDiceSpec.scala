package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class TenSidedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Ten sided dice") {
    val dice = new TenSidedDice(rng)

    val name = "D10"
    val range = DiceRange(1, 10)

    behavesLikeDice(dice, name, range, 9)
  }
}