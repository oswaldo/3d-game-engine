package com.example.game.core

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
