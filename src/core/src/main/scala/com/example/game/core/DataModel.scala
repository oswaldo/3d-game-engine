package com.example.game.core

/** Represents a 3D vector or point in space.
  * @param x The x-coordinate.
  * @param y The y-coordinate.
  * @param z The z-coordinate.
  */
case class Vector3(x: Float, y: Float, z: Float)

/** Represents the position, rotation, and scale of a game object.
  * @param position The position of the object.
  * @param rotation The rotation of the object (in Euler angles).
  * @param scale The scale of the object.
  */
case class Transform(
  position: Vector3 = Vector3(0, 0, 0),
  rotation: Vector3 = Vector3(0, 0, 0),
  scale: Vector3 = Vector3(1, 1, 1)
)

/** A trait representing a piece of functionality that can be attached to a `GameObject`.
  * This allows for a flexible, component-based architecture.
  */
trait Component

/** Represents an object in the game world.
  * @param name The name of the object.
  * @param transform The position, rotation, and scale of the object.
  * @param components The list of components that define the object's behavior and appearance.
  */
case class GameObject(
  name: String,
  transform: Transform = Transform(),
  components: List[Component] = Nil
)

/** Represents a collection of `GameObject`s that make up a single environment (2D or 3D).
  * @param name The name of the scene.
  * @param gameObjects The list of game objects in the scene.
  */
case class Scene(
  name: String,
  gameObjects: List[GameObject] = Nil
)
