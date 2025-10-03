# Data Model: Game Engine Core

This document defines the core data structures for the game engine, designed with immutability and type safety in mind.

## Core Entities

### `Vector3`
A simple case class to represent a 3D vector.
```scala
case class Vector3(x: Float, y: Float, z: Float)
```

### `Transform`
A case class to represent the position, rotation, and scale of a game object.
```scala
case class Transform(
  position: Vector3 = Vector3(0, 0, 0),
  rotation: Vector3 = Vector3(0, 0, 0),
  scale: Vector3 = Vector3(1, 1, 1)
)
```

### `Component`
A sealed trait representing a piece of functionality that can be attached to a `GameObject`. This allows for a flexible, component-based architecture.

```scala
sealed trait Component

// Example components (to be defined in their respective modules)
case class Sprite(image: String) extends Component
case class Mesh(model: String) extends Component
case class Script(script: String) extends Component
```

### `GameObject`
A case class representing an object in the game world. It has a name, a transform, and a list of components.

```scala
case class GameObject(
  name: String,
  transform: Transform = Transform(),
  components: List[Component] = Nil
)
```

### `Scene`
A case class representing a collection of `GameObject`s that make up a single environment (2D or 3D).

```scala
case class Scene(
  name: String,
  gameObjects: List[GameObject] = Nil
)
```
