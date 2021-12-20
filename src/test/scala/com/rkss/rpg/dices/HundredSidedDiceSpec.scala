package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class HundredSidedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Hundred sided dice") {
    val dice = new HundredSidedDice(rng)

    val name = "D100"
    val range = DiceRange(1, 100)

    behavesLikeDice(dice, name, range, 87)
  }
}