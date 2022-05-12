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
        val fixture = BasicIntFixture(name, BasicIntOptions(10))

        fixture.value shouldBe 10
      }
    }

    describe("minimum value") {
      it("should be 0") {
        val fixture = BasicIntFixture(name, BasicIntOptions(10, 0))

        fixture.minus(BasicIntValue(name, 100))

        fixture.value shouldBe 0
      }

      describe("changing minimum value") {
        it("should return 15") {
          val fixture = BasicIntFixture(name, BasicIntOptions(10, 0))

          fixture.minimum = 15

          fixture.minimum shouldBe 15
        }

        describe("when maximum is 50") {
          describe("and minimum is 30") {
            describe("and minimum changes to 52") {
              it("return minimum 30") {
                val fixture = BasicIntFixture(name, BasicIntOptions(40, 30, 50))

                fixture.minimum = 52

                fixture.minimum shouldBe 30
              }
            }
          }
        }

        describe("when options equalizeOnValueInferiorMinimum is true") {
          describe("and value is 10") {
            describe("and minimum changes to 20") {
              it("return value 20") {
                val fixture = BasicIntFixture(
                  name,
                  BasicIntOptions(10, equalizeOnValueInferiorMinimum = true)
                )

                fixture.minimum = 20

                fixture.value shouldBe 20
              }
            }
          }
        }
      }
    }

    describe("maximum value") {
      it("should be 0") {
        val fixture = BasicIntFixture(name, BasicIntOptions(10, 0, 50))

        fixture.plus(BasicIntValue(name, 100))

        fixture.value shouldBe 50
      }

      describe("changing maximum value") {
        it("should return 200") {
          val fixture = BasicIntFixture(name, BasicIntOptions(10, 0))

          fixture.maximum = 200

          fixture.maximum shouldBe 200
        }

        describe("when minimum is 30") {
          describe("and maximum is 50") {
            describe("and maximum changes to 29") {
              it("return maximum 50") {
                val fixture = BasicIntFixture(name, BasicIntOptions(40, 30, 50))

                fixture.maximum = 29

                fixture.maximum shouldBe 50
              }
            }
          }
        }

        describe("when options equalizeOnValueSuperiorMaximum is true") {
          describe("and value is 100") {
            describe("and maximum changes to 50") {
              it("return value 50") {
                val fixture = BasicIntFixture(
                  name,
                  BasicIntOptions(100, equalizeOnValueSuperiorMaximum = true)
                )

                fixture.maximum = 50

                fixture.value shouldBe 50
              }
            }
          }
        }
      }
    }

    describe("math operations") {
      it("should execute basic math") {
        val fixture = BasicIntFixture(name)

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
        val fixture =
          BasicIntFixture(name, BasicIntOptions(100, roundUp = true))

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
        val fixture = BasicIntFixture(name)

        fixture.plus(BasicIntValue(name, 10))
        fixture.multiply(BasicIntValue(name, 10))
        fixture.div(BasicIntValue(name, 10))
        fixture.minus(BasicIntValue(name, 10))

        fixture.history shouldBe expected
      }
    }
  }
}
