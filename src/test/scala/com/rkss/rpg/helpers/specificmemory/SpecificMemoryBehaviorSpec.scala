package com.rkss.rpg.helpers.specificmemory

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers._

final class SpecificMemoryBehaviorSpec extends AnyFunSpec with Matchers {
  describe("MemoryBehavior") {
    // PoC
    sealed trait CombatEvent extends GlobalNameTag

    case object DamageTaken extends CombatEvent
    case object HealReceived extends CombatEvent
    case object Resurrected extends CombatEvent

    sealed trait CombatAction { def name: CombatEvent }

    final case class DamageFact(
        val dmgType: String,
        val value: Int
    ) extends CombatAction {
      val name = DamageTaken
    }

    final case class HealFact(value: Int) extends CombatAction {
      val name = HealReceived
    }

    describe("acknowledge") {
      val memory = new SpecificMemoryBehavior[CombatAction]

      Seq(
        (DamageFact("shadow", 50), None),
        (HealFact(35), None),
        (HealFact(50), Some(HealFact(35)))
      ).foreach { case (fixture, expected) =>
        describe(s"when acknowledging ${fixture}") {
          it(s"should drop ${expected}") {
            val result = memory.acknowledge(fixture)

            result shouldBe expected
          }
        }
      }
    }

    describe("forget") {
      val memory = new SpecificMemoryBehavior[CombatAction]

      memory.acknowledge(HealFact(35))

      Seq((HealReceived, Some(HealFact(35))), (Resurrected, None)).foreach {
        case (fixture, expected) =>
          describe(s"when forgetting ${fixture}") {
            it(s"returns ${expected}") {
              val result = memory.forget(fixture)

              result shouldBe expected
            }
          }
      }
    }

    describe("remember") {
      val memory = new SpecificMemoryBehavior[CombatAction]

      memory.acknowledge(HealFact(35))

      Seq((HealReceived, Some(HealFact(35))), (Resurrected, None)).foreach {
        case (fixture, expected) =>
          describe(s"when remembering ${fixture}") {

            it(s"returns ${expected}") {
              val result = memory.remember(fixture)

              result shouldBe expected
            }
          }
      }

      describe("when remembering from amnesia") {
        val memory = new SpecificMemoryBehavior[CombatAction]

        memory.acknowledge(HealFact(35))
        memory.acknowledge(DamageFact("poison", 35))

        memory.forget(HealReceived)
        memory.forget(DamageTaken, true)

        Seq(
          (HealReceived, None, false),
          (Resurrected, None, true),
          (DamageTaken, Some(DamageFact("poison", 35)), true)
        ).foreach { case (fixture, expected, amnesia) =>
          describe(s"when remembering ${fixture}") {
            describe(s"when amnesia is ${amnesia}") {
              it(s"returns ${expected}") {
                val result = memory.remember(fixture, amnesia)

                result shouldBe expected

                memory.remember(fixture) shouldBe expected
              }
            }
          }
        }

        describe("when forgetting a second time without amnesia") {
          it("return None") {
            val memory = new SpecificMemoryBehavior[CombatAction]

            memory.acknowledge(HealFact(35))

            memory.forget(HealReceived, true)

            memory.remember(HealReceived, true) shouldBe Some(HealFact(35))

            memory.forget(HealReceived)

            memory.remember(HealReceived, true) shouldBe None
          }
        }

        describe("when amnesia has a fact with same name not related") {
          it("should not remember from amnesia") {
            val memory = new SpecificMemoryBehavior[CombatAction]

            memory.acknowledge(HealFact(35))

            memory.forget(HealReceived, true)

            memory.acknowledge(HealFact(35))

            memory.forget(HealReceived)

            memory.remember(HealReceived, true) shouldBe None
          }
        }
      }
    }

    describe("wipe") {
      it("erases all memories") {
        val memory = new SpecificMemoryBehavior[CombatAction]

        val expected = Seq(HealFact(35), DamageFact("poison", 35))

        expected.foreach(m => memory.acknowledge(m))

        val result = memory.wipe()

        memory.remember(HealReceived) shouldBe None
        memory.remember(DamageTaken) shouldBe None

        result shouldBe expected
      }

      describe("when amnesia is enabled") {
        it("allows to remember") {
          val memory = new SpecificMemoryBehavior[CombatAction]

          val expected = Seq(HealFact(35), DamageFact("poison", 35))

          expected.foreach(m => memory.acknowledge(m))

          val result = memory.wipe(true)

          memory.remember(HealReceived, true) shouldBe Some(HealFact(35))
          memory.remember(DamageTaken, true) shouldBe Some(
            DamageFact("poison", 35)
          )

          result shouldBe expected
        }
      }
    }
  }
}
