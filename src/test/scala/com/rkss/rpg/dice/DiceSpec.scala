package com.rkss.rpg.dice

import com.rkss.rpg.dice.imaginary._
import com.rkss.rpg.dice.implementation.SimpleDiceRange

class DiceSpec extends BehavesLikeDice {
  describe("Four sided dice") {
    val dice = FourSidedDice(rng)

    val name = "D4"
    val range = SimpleDiceRange(1, 4)

    behavesLikeDice(dice, name, range, 2)
  }

  describe("Six sided dice") {
    val dice = SixSidedDice(rng)

    val name = "D6"
    val range = SimpleDiceRange(1, 6)

    behavesLikeDice(dice, name, range, 5)
  }

  describe("Eight sided dice") {
    val dice = EightSidedDice(rng)

    val name = "D8"
    val range = SimpleDiceRange(1, 8)

    behavesLikeDice(dice, name, range, 5)
  }

  describe("Ten sided dice") {
    val dice = TenSidedDice(rng)

    val name = "D10"
    val range = SimpleDiceRange(1, 10)

    behavesLikeDice(dice, name, range, 9)
  }

  describe("Twelve sided dice") {
    val dice = TwelveSidedDice(rng)

    val name = "D12"
    val range = SimpleDiceRange(1, 12)

    behavesLikeDice(dice, name, range, 11)
  }

  describe("Twenty sided dice") {
    val dice = TwentySidedDice(rng)

    val name = "D20"
    val range = SimpleDiceRange(1, 20)

    behavesLikeDice(dice, name, range, 17)
  }

  describe("Hundred sided dice") {
    val dice = HundredSidedDice(rng)

    val name = "D100"
    val range = SimpleDiceRange(1, 100)

    behavesLikeDice(dice, name, range, 87)
  }

  describe("Imaginary Three sided dice") {
    val dice = ThreeSidedDice(rng)

    val name = "D3"
    val range = SimpleDiceRange(1, 3)

    behavesLikeDice(dice, name, range, 3)
  }

  describe("Imaginary Two sided dice") {
    val dice = TwoSidedDice(rng)

    val name = "D2"
    val range = SimpleDiceRange(1, 2)

    behavesLikeDice(dice, name, range, 2)
  }
}
