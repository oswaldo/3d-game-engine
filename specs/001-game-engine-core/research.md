# Research: Game Engine Core

## 3D Rendering Library

- **Decision**: Use LWJGL (Lightweight Java Game Library) for 3D rendering.
- **Rationale**: LWJGL provides low-level, cross-platform access to graphics APIs like OpenGL and Vulkan. While it is a Java library, it is highly performant and provides the necessary bindings to implement a 3D renderer. Creating a pure Scala 3D renderer from scratch is a significant undertaking that is outside the scope of a "simple" game engine. LWJGL is a mature and stable choice. We will wrap it in an idiomatic Scala API.
- **Alternatives considered**:
  - A pure Scala library: No mature, feature-complete pure Scala 3D rendering libraries with cross-platform support were identified.

## 2D Rendering Library

- **Decision**: Use the ScalaFX `Canvas` API for 2D rendering.
- **Rationale**: ScalaFX is already a dependency for the UI. Its `Canvas` API provides a low-level, immediate-mode rendering surface that is sufficient for simple 2D games and environments. This aligns with the "Lightweight and Minimal Dependencies" principle by leveraging an existing library instead of adding a new one.
- **Alternatives considered**:
  - A dedicated 2D game library: This would add another dependency and potentially conflict with ScalaFX for the UI. For a simple engine, the `Canvas` is sufficient.
