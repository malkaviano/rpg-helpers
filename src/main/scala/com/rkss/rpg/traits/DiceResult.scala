package com.rkss.rpg.traits

trait DiceResult  extends Ordered[DiceResult] {
  def value: Int

  override def compare(that: DiceResult): Int = {
    Integer.compare(this.value, that.value)
  }
}

object DiceResult {
  object implicits {
    implicit def toInt(diceResult: DiceResult): Int = {
      diceResult.value
    }
  }
}
