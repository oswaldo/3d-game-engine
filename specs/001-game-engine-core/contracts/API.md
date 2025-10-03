# API Contracts: Game Engine Core

This document outlines the public-facing API for the game engine. These traits and methods will be the primary entry points for developers using the engine.

## Core API

Defines the main entry point for interacting with the engine.

```scala
trait GameEngine {
  /**
   * Starts the game engine and runs the main loop.
   * @param initialScene The first scene to load.
   */
  def run(initialScene: Scene): Unit

  /**
   * Loads a new scene, replacing the current one.
   * @param scene The new scene to load.
   */
  def loadScene(scene: Scene): Unit
}
```

## UI API

Provides functionalities for creating and managing 2D menus and UI elements.

```scala
trait UI {
  /**
   * Creates a new menu.
   * @param name The name of the menu.
   * @param elements The UI elements within the menu.
   * @return The created Menu.
   */
  def createMenu(name: String, elements: List[UIElement]): Menu
}

sealed trait UIElement
case class Button(text: String, onClick: () => Unit) extends UIElement
case class Label(text: String) extends UIElement
```

## Rendering APIs

The rendering APIs will be internal to the engine and not directly exposed to the user. The `Scene` and `GameObject` data structures will be used to define what gets rendered.
