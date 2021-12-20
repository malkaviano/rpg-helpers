package com.rkss.rpg.dices

class SixSidedDiceSpec extends BehavesLikeDice {
  describe("Six sided dice") {
    val dice = new SixSidedDice(rng)

    val name = "D6"
    val range = DiceRange(1, 6)

    behavesLikeDice(dice, name, range, 5)
  }
}
