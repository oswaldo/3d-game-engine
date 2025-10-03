package com.example.game.renderer2d

import com.example.game.core._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import scalafx.scene.canvas.Canvas
import javax.swing.JFXPanel
import java.io.File

class Renderer2DSpec extends AnyWordSpec with Matchers {

  // Initialize the JavaFX toolkit for tests that require it.
  new JFXPanel()

  "Renderer2D" should {
    "render a Scene with a Sprite without errors" in {
      val canvas = new Canvas(100, 100)
      val renderer = new Renderer2D(canvas)

      val imagePath = "test-sprite-for-spec.png"
      val imageFile = new File(imagePath)
      try {
        imageFile.createNewFile()

        val sprite = Sprite(imagePath)
        val player = GameObject("Player", components = List(sprite))
        val scene = Scene("Game Scene", gameObjects = List(player))

        // The test passes if this method executes without throwing an exception.
        noException should be thrownBy {
          renderer.render(scene)
        }
      } finally {
        imageFile.delete()
      }
    }
  }
}
