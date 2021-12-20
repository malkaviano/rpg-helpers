package com.rkss.rpg.dices

class HundredSidedDiceSpec extends BehavesLikeDice {
  describe("Hundred sided dice") {
    val dice = new HundredSidedDice(rng)

    val name = "D100"
    val range = DiceRange(1, 100)

    behavesLikeDice(dice, name, range, 87)
  }
}