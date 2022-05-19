package com.rkss.rpg.helpers.dice

trait Dice {
  def name: DiceName
  def roll: DiceResult
}
