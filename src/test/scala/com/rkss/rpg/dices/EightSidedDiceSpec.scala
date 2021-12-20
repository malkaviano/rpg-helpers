package com.rkss.rpg.dices

class EightSidedDiceSpec extends BehavesLikeDice {
  describe("Eight sided dice") {
    val dice = new EightSidedDice(rng)

    val name = "D8"
    val range = DiceRange(1, 8)

    behavesLikeDice(dice, name, range, 5)
  }
}
