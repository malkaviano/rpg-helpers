package com.rkss.rpg.helpers.basicint

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.GlobalNameTag

class BasicIntBehaviorSpec extends AnyFunSpec with Matchers {
  describe("BasicIntBehavior companion object") {
    it("should create a BasicIntBehaviorImpl") {
      trait GG extends GlobalNameTag

      val name = new GG {}

      val basicInt = BasicIntBehavior(name)

      basicInt shouldBe a[BasicIntBehaviorImpl[_]]
    }

    it("should create a BasicIntDynamicBehaviorImpl") {
      trait GG extends GlobalNameTag

      val name = new GG {}

      val dynamicOption = BasicIntDynamicOptions(() => 10)

      val basicInt = BasicIntBehavior(name, dynamicOption)

      basicInt shouldBe a[BasicIntDynamicBehaviorImpl[_]]
    }
  }
}
