package com.rkss.rpg.dices

class TenSidedDiceSpec extends BehavesLikeDice {
  describe("Ten sided dice") {
    val dice = new TenSidedDice(rng)

    val name = "D10"
    val range = DiceRange(1, 10)

    behavesLikeDice(dice, name, range, 9)
  }
}