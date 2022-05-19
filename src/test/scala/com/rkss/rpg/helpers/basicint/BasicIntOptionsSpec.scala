package com.rkss.rpg.helpers.basicint

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

final class BasicIntOptionsSpec extends AnyFunSpec with Matchers {
  describe("Maintaining a consistent state on creation") {
    describe("when initial is 10") {
      describe("and minimum is 20") {
        it("returns minimum 10") {
          val options = BasicIntOptions(10, 20)

          options.minimumValue shouldBe 10
        }
      }

      describe("and maximum is 5") {
        it("returns maximum 10") {
          val options = BasicIntOptions(10, 20, 5)

          options.maximumValue shouldBe 10
        }
      }
    }
  }
}
