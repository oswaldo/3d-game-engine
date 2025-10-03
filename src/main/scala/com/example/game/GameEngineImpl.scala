package com.example.game

import com.example.game.core.{GameEngine, Scene}
import com.example.game.renderer2d.Renderer2D
import com.example.game.renderer3d.Renderer3D
import com.example.game.ui.{UI, UIImpl}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp3
import scalafx.scene.canvas.Canvas

class GameEngineImpl(stage: JFXApp3.PrimaryStage) extends GameEngine {

  private var currentScene: Option[Scene] = None
  private val renderer3D = new Renderer3D()

  private val canvas = new Canvas(800, 600)
  private val renderer2D = new Renderer2D(canvas)

  private val ui: UI = new UIImpl(stage)

  override def run(initialScene: Scene): Unit = {
    loadScene(initialScene)
    renderer3D.init() // Initialize the 3D renderer

    val timer = AnimationTimer { _ =>
      currentScene.foreach(scene => {
        if (scene.name.contains("3D")) {
          renderer3D.render(scene)
        } else {
          renderer2D.render(scene)
        }
      })

      if (renderer3D.windowShouldClose) {
        renderer3D.cleanup()
      }
    }
    timer.start()
  }

  override def loadScene(scene: Scene): Unit = {
    currentScene = Some(scene)
  }
}
