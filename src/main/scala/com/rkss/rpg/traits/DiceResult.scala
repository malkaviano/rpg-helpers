package com.rkss.rpg.traits

trait DiceResult {
  def value: Int
}

object DiceResult {
  object implicits {
    implicit def toInt(diceResult: DiceResult): Int = {
      diceResult.value
    }
  }
}
