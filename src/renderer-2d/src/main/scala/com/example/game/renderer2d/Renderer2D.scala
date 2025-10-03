package com.example.game.renderer2d

import com.example.game.core.{GameObject, Scene}
import scalafx.scene.canvas.Canvas
import scalafx.scene.image.Image

class Renderer2D(canvas: Canvas) {

  private val gc = canvas.graphicsContext2D

  def render(scene: Scene): Unit = {
    // A more complete implementation would clear the canvas first
    // gc.clearRect(0, 0, canvas.width.value, canvas.height.value)

    scene.gameObjects.foreach(renderGameObject)
  }

  private def renderGameObject(gameObject: GameObject): Unit = {
    gameObject.components.foreach {
      case Sprite(imagePath) =>
        // This is a simplified implementation. A real implementation would cache images.
        // It also assumes the image path is relative to the project root.
        val image = new Image(s"file:$imagePath")
        val transform = gameObject.transform
        if (!image.error.value) {
            gc.drawImage(
              image,
              transform.position.x,
              transform.position.y,
              image.width.value * transform.scale.x,
              image.height.value * transform.scale.y
            )
        }
      case _ => () // Ignore other components
    }
  }
}
