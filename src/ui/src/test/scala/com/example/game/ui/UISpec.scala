package com.example.game.ui

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class UISpec extends AnyWordSpec with Matchers {

  "UI" should {
    "create a menu with elements" in {
      // This is a mock implementation for testing purposes
      class MockUI extends UI {
        override def createMenu(name: String, elements: List[UIElement]): Menu = {
          Menu(name, elements)
        }
      }

      val ui = new MockUI()
      val button = Button("Test Button", () => ())
      val label = Label("Test Label")
      val menu = ui.createMenu("Test Menu", List(button, label))

      menu.name should be("Test Menu")
      menu.elements should contain theSameElementsAs (List(button, label))
    }
  }
}
