package com.rkss.rpg.helpers.basicint

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.GlobalNameTag

class BasicIntDynamicBehaviorImplSpec extends AnyFunSpec with Matchers {
  trait GG extends GlobalNameTag
  val name = new GG {}

  describe("BasicIntDynamicBehaviorImpl behavior") {
    describe("initial value") {
      it("should be 10") {
        val fixture =
          BasicIntDynamicBehaviorImpl(name, BasicIntDynamicOptions(() => 10))

        fixture.value shouldBe 10
      }
    }

    describe("math operations") {
      it("should execute basic math") {
        var source = 0
        val fixture = BasicIntDynamicBehaviorImpl(
          name,
          BasicIntDynamicOptions(() => source)
        )

        fixture.plus(BasicIntValue(name, 10))
        fixture.value shouldBe 10

        fixture.minus(BasicIntValue(name, 5))
        fixture.value shouldBe 5

        fixture.multiply(BasicIntValue(name, 2))
        fixture.value shouldBe 10

        fixture.div(BasicIntValue(name, 4))
        fixture.value shouldBe 2

        source = 10

        fixture.value shouldBe 7
      }
    }

    describe("minimum and maximum value") {
      it("should respect the limits") {
        val fixture = BasicIntDynamicBehaviorImpl(
          name,
          BasicIntDynamicOptions(() => 10, 0, 20)
        )

        fixture.value shouldBe 10

        fixture.plus(BasicIntValue(name, 15))
        fixture.value shouldBe 20

        fixture.minus(BasicIntValue(name, 30))
        fixture.value shouldBe 0
      }
    }

    describe("on value changed") {
      describe("when a callback is defined") {
        it("should call the callback when value changes") {
          val source = 10
          val fixture = BasicIntDynamicBehaviorImpl(
            name,
            BasicIntDynamicOptions(() => source, 0, 50)
          )

          var old = 0
          var current = 0

          fixture.onValueChanged((o, c) => {
            old = o
            current = c
          })

          fixture.plus(BasicIntValue(name, 10))

          old shouldBe 10
          current shouldBe 20
        }

        it("should not call the callback when value is the same") {
          val source = 10
          val fixture = BasicIntDynamicBehaviorImpl(
            name,
            BasicIntDynamicOptions(() => source, 0, 50)
          )

          var old = 0
          var current = 0

          fixture.onValueChanged((o, c) => {
            old = o
            current = c
          })

          fixture.plus(BasicIntValue(name, 0))

          old shouldBe 0
          current shouldBe 0
        }

        describe("when clearOnValueChanged is called") {
          it("should not call the callback") {
            val source = 10
            val fixture = BasicIntDynamicBehaviorImpl(
              name,
              BasicIntDynamicOptions(() => source, 0, 50)
            )

            var old = 0
            var current = 0

            fixture.onValueChanged((o, c) => {
              old = o
              current = c
            })

            fixture.clearOnValueChanged()

            fixture.plus(BasicIntValue(name, 10))

            old shouldBe 0
            current shouldBe 0
          }
        }
      }
    }

    describe("rounding up on division") {
      it("should be 13") {
        val source = 100
        val fixture =
          BasicIntDynamicBehaviorImpl(
            name,
            BasicIntDynamicOptions(() => source, roundUp = true)
          )

        fixture.div(BasicIntValue(name, 8))

        fixture.value shouldBe 13
      }
    }
  }
}
