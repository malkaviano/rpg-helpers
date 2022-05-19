package com.rkss.rpg.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.helpers._

class EventHubSpec extends AnyFunSpec with Matchers {
  trait GG extends GlobalNameTag

  val name = new GG {}

  describe("EventHub shout") {
    final case class Listener(val id: String) {
      var result: Int = _

      def callMe(event: BasicIntEvent): Unit = {
        result += event.current
      }
    }

    it("should publish the event to listeners") {
      val fixture = BasicIntBehavior(name, BasicIntOptions(id = "basicint1"))

      val fixture2 = BasicIntBehavior(name, BasicIntOptions(id = "basicint2"))

      val listener = Listener("listener1")

      val listener2 = Listener("listener2")

      val listener3 = Listener("listener3")

      EventHub.addListener(fixture.id, listener.id, listener.callMe)

      EventHub.addListener(fixture.id, listener2.id, listener2.callMe)

      EventHub.addListener(fixture.id, listener3.id, listener3.callMe)

      EventHub.addListener(fixture2.id, listener3.id, listener3.callMe)

      fixture.plus(BasicIntValue(name, 100))

      fixture2.plus(BasicIntValue(name, 1000))

      EventHub.removeListener(fixture.id, listener.id)

      fixture.minimum = 200

      listener.result shouldBe 100

      listener2.result shouldBe 300

      listener3.result shouldBe 1300
    }
  }
}
