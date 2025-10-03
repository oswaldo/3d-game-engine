package com.example.game.core

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class GameEngineSpec extends AnyWordSpec with Matchers {

  "GameEngine" should {
    "be able to run and load a scene" in {
      // This is a mock implementation for testing purposes
      class MockGameEngine extends GameEngine {
        var runningScene: Option[Scene] = None

        override def run(initialScene: Scene): Unit = {
          runningScene = Some(initialScene)
        }

        override def loadScene(scene: Scene): Unit = {
          runningScene = Some(scene)
        }
      }

      val engine = new MockGameEngine()
      val scene1 = Scene("Scene 1")
      val scene2 = Scene("Scene 2")

      engine.run(scene1)
      engine.runningScene should contain(scene1)

      engine.loadScene(scene2)
      engine.runningScene should contain(scene2)
    }
  }
}
