package com.rkss.rpg.helpers.fixtures

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.traits._

final class BasicIntFixtureSpec extends AnyFunSpec with Matchers {
  trait GG extends GlobalNameTag

  val name = new GG {}

  describe("BasicIntFixture behavior") {
    describe("initial value") {
      it("should be 10") {
        val fixture = BasicIntFixture(name, 10)

        fixture.value shouldBe 10
      }
    }

    describe("minimum value") {
      it("should be 0") {
        val fixture = BasicIntFixture(name, 10, 0)

        fixture.minus(BasicIntValue(name, 100))

        fixture.value shouldBe 0
      }
    }

    describe("maximum value") {
      it("should be 0") {
        val fixture = BasicIntFixture(name, 10, 0, 50)

        fixture.plus(BasicIntValue(name, 100))

        fixture.value shouldBe 50
      }
    }

    describe("math operations") {
      it("should execute basic math") {
        val fixture = BasicIntFixture(name, 0)

        fixture.plus(BasicIntValue(name, 10))

        fixture.value shouldBe 10

        fixture.multiply(BasicIntValue(name, 10))

        fixture.value shouldBe 100

        fixture.div(BasicIntValue(name, 8))

        fixture.value shouldBe 12

        fixture.minus(BasicIntValue(name, 12))

        fixture.value shouldBe 0
      }
    }

    describe("rounding up on division") {
      it("should be 13") {
        val fixture = BasicIntFixture(name, 100, roundUp = true)

        fixture.div(BasicIntValue(name, 8))

        fixture.value shouldBe 13
      }
    }

    describe("history") {
      val expected = List(
        BasicIntLog(name, 10, 0, BasicIntOperationPlus),
        BasicIntLog(name, 100, 10, BasicIntOperationMultiply),
        BasicIntLog(name, 10, 100, BasicIntOperationDiv),
        BasicIntLog(name, 0, 10, BasicIntOperationMinus)
      )
      it(s"should be a list with 4 logs") {
        val fixture = BasicIntFixture(name, 0)

        fixture.plus(BasicIntValue(name, 10))
        fixture.multiply(BasicIntValue(name, 10))
        fixture.div(BasicIntValue(name, 10))
        fixture.minus(BasicIntValue(name, 10))

        fixture.history shouldBe expected
      }
    }
  }
}
