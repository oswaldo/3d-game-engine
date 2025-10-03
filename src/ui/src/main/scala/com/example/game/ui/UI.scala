package com.example.game.ui

import com.example.game.core.Component

/** A sealed trait representing a single element within a UI, such as a button or a label. */
sealed trait UIElement

/** A clickable button UI element.
  * @param text The text displayed on the button.
  * @param onClick The action to perform when the button is clicked.
  */
case class Button(text: String, onClick: () => Unit) extends UIElement

/** A non-interactive text label UI element.
  * @param text The text to display.
  */
case class Label(text: String) extends UIElement

/** A component that represents a collection of UI elements, forming a menu.
  * @param name The name of the menu.
  * @param elements The list of `UIElement`s in the menu.
  */
case class Menu(name: String, elements: List[UIElement]) extends Component

/** A trait that defines the contract for creating UI components. */
trait UI {
  /**
   * Creates a new menu.
   * @param name The name of the menu.
   * @param elements The UI elements within the menu.
   * @return The created Menu.
   */
  def createMenu(name: String, elements: List[UIElement]): Menu
}
