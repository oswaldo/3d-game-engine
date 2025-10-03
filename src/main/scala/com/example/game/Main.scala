package com.example.game

import com.example.game.core._
import com.example.game.renderer2d.Sprite
import com.example.game.renderer3d.Mesh
import com.example.game.ui._
import scalafx.application.JFXApp3

object Main extends JFXApp3 {

  override def start(): Unit = {

    val engine = GameEngineFactory.create(stage)

    // Define scenes
    val scene2D = Scene(
      name = "2D Scene",
      gameObjects = List(GameObject("Player", components = List(Sprite("player.png"))))
    )

    val scene3D = Scene(
      name = "3D Scene",
      gameObjects = List(GameObject("Cube", components = List(Mesh("cube.obj"))))
    )

    // Define menu with actions
    val menu = Menu("Main Menu", List(
      Button("Play 2D", () => engine.loadScene(scene2D)),
      Button("Play 3D", () => engine.loadScene(scene3D))
    ))

    val menuScene = Scene("Main Menu", List(GameObject("UI", components = List(menu))))

    // Run the engine
    engine.run(menuScene)
  }
}
