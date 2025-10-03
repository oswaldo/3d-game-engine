# Quickstart: Game Engine Core

This guide provides a basic example of how to use the game engine to create a simple application with a 2D menu that loads a 2D or 3D scene.

## 1. Set up the project

Add the game engine as a dependency to your `build.sbt` file:

```scala
libraryDependencies += "com.example" %% "game-engine" % "0.1.0-SNAPSHOT"
```

## 2. Create the Main Application

Create a main application object that extends `scalafx.application.JFXApp3` and initializes the game engine.

```scala
import com.example.game.core._
import com.example.game.ui._
import scalafx.application.JFXApp3

object Main extends JFXApp3 {
  override def start(): Unit = {
    val engine: GameEngine = ??? // GameEngineFactory.create()

    val menuScene = Scene(
      name = "Main Menu",
      gameObjects = List(
        GameObject(
          name = "MainMenuUI",
          components = List(
            // The UI component will be created via the UI API
          )
        )
      )
    )

    engine.run(menuScene)
  }
}
```

## 3. Create the Scenes

Define the 2D and 3D scenes that will be loaded from the menu.

```scala
val scene2D = Scene(
  name = "2D Scene",
  gameObjects = List(
    GameObject(
      name = "Player",
      components = List(Sprite("player.png"))
    )
  )
)

val scene3D = Scene(
  name = "3D Scene",
  gameObjects = List(
    GameObject(
      name = "Cube",
      components = List(Mesh("cube.obj"))
    )
  )
)
```

## 4. Create the Menu

Use the `UI` api to create the main menu with buttons to load the scenes.

```scala
val ui: UI = ??? // engine.ui

val mainMenu = ui.createMenu("Main Menu", List(
  Button("Play 2D", () => engine.loadScene(scene2D)),
  Button("Play 3D", () => engine.loadScene(scene3D))
))
```
