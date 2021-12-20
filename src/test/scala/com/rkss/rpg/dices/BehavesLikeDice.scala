package com.rkss.rpg.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.rkss.rpg.traits._
import com.rkss.rpg.dices.implementation._

trait BehavesLikeDice extends AnyFunSpec with Matchers with MockFactory {
  protected lazy val rng = mockFunction[DiceRange, DiceResult]

  def behavesLikeDice(
      dice: Dice,
      name: String,
      range: DiceRange,
      expected: Int
  ) = {
    it(s"should have name ${name}") {
      val result: String = dice.name.toString

      result shouldEqual name
    }

    it(s"should have roll result between ${range}") {
      import com.rkss.rpg.traits.DiceResult.implicits._

      rng.expects(range).once().returning(SimpleDiceResult(expected))

      val result: Int = dice.roll

      result shouldBe expected
    }
  }
}
