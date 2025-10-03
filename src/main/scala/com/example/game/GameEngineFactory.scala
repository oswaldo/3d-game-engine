package com.example.game

import com.example.game.core.GameEngine
import scalafx.application.JFXApp3

/**
 * A factory for creating instances of the `GameEngine`.
 */
object GameEngineFactory {
  /**
   * Creates a new instance of the game engine.
   * @param stage The primary stage of the ScalaFX application, used for rendering UI and 2D content.
   * @return A new `GameEngine` instance.
   */
  def create(stage: JFXApp3.PrimaryStage): GameEngine = {
    new GameEngineImpl(stage)
  }
}
