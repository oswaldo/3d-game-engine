package com.example.game

import com.example.game.core._
import com.example.game.ui._
import com.example.game.renderer2d.Sprite
import com.example.game.renderer3d.Mesh
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class QuickstartIntegrationSpec extends AnyWordSpec with Matchers {

  // A mock implementation of the full engine for testing purposes
  class TestGameEngine extends GameEngine {
    private var currentScene: Option[Scene] = None
    val scenesLoaded: mutable.Buffer[String] = mutable.Buffer.empty

    override def run(initialScene: Scene): Unit = {
      loadScene(initialScene)
    }

    override def loadScene(scene: Scene): Unit = {
      currentScene = Some(scene)
      scenesLoaded += scene.name
    }

    def getCurrentScene: Option[Scene] = currentScene
  }

  "GameEngine Quickstart" should {
    "follow the user story from quickstart.md" in {
      val engine = new TestGameEngine()

      val scene2D = Scene(
        name = "2D Scene",
        gameObjects = List(GameObject("Player", components = List(Sprite("player.png"))))
      )

      val scene3D = Scene(
        name = "3D Scene",
        gameObjects = List(GameObject("Cube", components = List(Mesh("cube.obj"))))
      )

      var play2DAction: () => Unit = () => ()
      var play3DAction: () => Unit = () => ()

      val menu = Menu("Main Menu", List(
        Button("Play 2D", () => play2DAction()),
        Button("Play 3D", () => play3DAction())
      ))

      val menuScene = Scene("Main Menu", List(GameObject("UI", components = List(menu))))

      engine.run(menuScene)
      engine.getCurrentScene.map(_.name).should(be(Some("Main Menu")))

      play2DAction = () => engine.loadScene(scene2D)
      play3DAction = () => engine.loadScene(scene3D)

      play2DAction()
      engine.getCurrentScene.map(_.name).should(be(Some("2D Scene")))
      engine.scenesLoaded.should(contain.allOf("Main Menu", "2D Scene"))

      play3DAction()
      engine.getCurrentScene.map(_.name).should(be(Some("3D Scene")))
      engine.scenesLoaded.should(contain.allOf("Main Menu", "2D Scene", "3D Scene"))
    }
  }
}
