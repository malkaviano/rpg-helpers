package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.rkss.rpg.traits.Dice

trait BehavesLikeDice extends AnyFunSpec with Matchers with MockFactory {
  protected lazy val rng = mockFunction[DiceRange, Int]

  def behavesLikeDice(
      dice: Dice,
      name: String,
      range: DiceRange,
      expected: Int
  ) = {
    it(s"should have name ${name}") {
      dice.name.toString shouldEqual name
    }

    it(s"should have roll generating a number between ${range}") {
      rng.expects(range).once().returning(expected)

      dice.roll shouldBe expected
    }
  }
}
