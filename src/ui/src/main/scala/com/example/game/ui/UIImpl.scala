package com.example.game.ui

import scalafx.application.JFXApp3
import scalafx.scene.control.{Button as FxButton, Label as FxLabel}
import scalafx.scene.layout.VBox
import scalafx.scene.{Scene as FxScene}
import scalafx.Includes._ // Import for the event handler conversion

class UIImpl(stage: JFXApp3.PrimaryStage) extends UI {
  override def createMenu(name: String, elements: List[UIElement]): Menu = {
    val fxElements = elements.map {
      case Button(text, onClick) => new FxButton(text) { onAction = () => onClick() }
      case Label(text) => new FxLabel(text)
    }

    val layout = new VBox(10, fxElements*)
    val fxScene = new FxScene(layout, 400, 300)

    stage.scene = fxScene
    stage.title = name

    Menu(name, elements)
  }
}
