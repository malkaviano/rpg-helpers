package com.rkss.rpg.dices

class FourSidedDiceSpec extends BehavesLikeDice {
  describe("Four sided dice") {
    val dice = new FourSidedDice(rng)

    val name = "D4"
    val range = DiceRange(1, 4)

    behavesLikeDice(dice, name, range, 2)
  }
}
