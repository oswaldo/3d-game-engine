# Tasks: Game Engine Core

**Input**: Design documents from `/specs/001-game-engine-core/`
**Prerequisites**: plan.md, research.md, data-model.md, contracts/

## Format: `[ID] [P?] Description`
- **[P]**: Can run in parallel (different files, no dependencies)
- Include exact file paths in descriptions

## Phase 3.1: Project Setup
- [ ] T001 Create the multi-module sbt project structure as defined in `plan.md` (directories for `core`, `ui`, `renderer-2d`, `renderer-3d`).
- [ ] T002 Update the root `build.sbt` to define the sbt modules and add initial dependencies: `scalafx`, `scalatest`, and `lwjgl`.
- [ ] T003 [P] Configure Scalafmt for the project by creating a `.scalafmt.conf` file in the repository root.

## Phase 3.2: Core Data Model Implementation
- [ ] T004 [P] Implement `Vector3` and `Transform` case classes in `src/core/src/main/scala/com/example/game/core/DataModel.scala`.
- [ ] T005 [P] Implement the `Component` sealed trait in `src/core/src/main/scala/com/example/game/core/DataModel.scala`.
- [ ] T006 [P] Implement the `GameObject` case class in `src/core/src/main/scala/com/example/game/core/DataModel.scala`.
- [ ] T007 [P] Implement the `Scene` case class in `src/core/src/main/scala/com/example/game/core/DataModel.scala`.

## Phase 3.3: API Contract Tests (TDD)
**CRITICAL: These tests MUST be written and MUST FAIL before ANY implementation**
- [ ] T008 [P] Create a failing unit test for the `GameEngine` trait in `src/core/src/test/scala/com/example/game/core/GameEngineSpec.scala`. The test should define a mock implementation and assert that its methods can be called.
- [ ] T009 [P] Create a failing unit test for the `UI` trait in `src/ui/src/test/scala/com/example/game/ui/UISpec.scala`. The test should check if a mock `UI` can create a `Menu`.

## Phase 3.4: Core API Implementation
- [ ] T010 Implement the `GameEngine` trait in `src/core/src/main/scala/com/example/game/core/GameEngine.scala`.
- [ ] T011 Implement the `UI` trait and its related case classes (`UIElement`, `Button`, `Label`) in `src/ui/src/main/scala/com/example/game/ui/UI.scala`.
- [ ] T012 Create a `GameEngineFactory` object in `src/core/src/main/scala/com/example/game/core/GameEngineFactory.scala` to handle the creation of the engine instance.

## Phase 3.5: 2D Renderer Module (TDD)
- [ ] T013 [P] Create a failing test for the 2D renderer in `src/renderer-2d/src/test/scala/com/example/game/renderer2d/Renderer2DSpec.scala`. This test should attempt to render a `Scene` with a `Sprite` onto a mock ScalaFX `Canvas`.
- [ ] T014 Implement the `Sprite` component in `src/renderer-2d/src/main/scala/com/example/game/renderer2d/Components.scala`.
- [ ] T015 Implement a `Renderer2D` class in `src/renderer-2d/src/main/scala/com/example/game/renderer2d/Renderer2D.scala` that takes a `Scene` and renders it to a `Canvas`.

## Phase 3.6: 3D Renderer Module (TDD)
- [ ] T016 [P] Create a failing test for the 3D renderer in `src/renderer-3d/src/test/scala/com/example/game/renderer3d/Renderer3DSpec.scala`. This test should attempt to render a `Scene` with a `Mesh` component.
- [ ] T017 Implement the `Mesh` component in `src/renderer-3d/src/main/scala/com/example/game/renderer3d/Components.scala`.
- [ ] T018 Implement a `Renderer3D` class in `src/renderer-3d/src/main/scala/com/example/game/renderer3d/Renderer3D.scala` that sets up an LWJGL OpenGL context and renders a `Scene`.

## Phase 3.7: Integration and Finalization
- [ ] T019 Integrate the `Renderer2D` and `Renderer3D` modules into the main `GameEngine` implementation.
- [ ] T020 Integrate the `UI` module with the `GameEngine` to allow rendering of UI elements.
- [ ] T021 [P] Create a failing integration test based on `quickstart.md` in `src/core/src/test/scala/com/example/game/core/QuickstartIntegrationSpec.scala`.
- [ ] T022 Implement the necessary logic to make the `QuickstartIntegrationSpec` pass, wiring all modules together.
- [ ] T023 [P] Add Scaladoc documentation to all public traits and methods in the `core` and `ui` modules.
- [ ] T024 [P] Create a `Main.scala` example application in `src/main/scala/com/example/game/Main.scala` as described in `quickstart.md`.
- [ ] T025 Review the entire codebase and remove any remaining `???` placeholders.

## Dependencies
- **Setup (T001-T003)** must be done first.
- **Data Model (T004-T007)** can be done in parallel but must be complete before other phases.
- **API Tests (T008-T009)** must be done before API Implementation (T010-T012).
- **Renderer Tests (T013, T016)** must be done before their respective implementations (T014-T015, T017-T018).
- **Integration (T019-T022)** must happen after all modules are implemented.
- **Polish (T023-T025)** is the final step.

## Parallel Example
```
# The data model can be implemented in parallel:
/implement T004
/implement T005
/implement T006
/implement T007

# The initial API and renderer tests can also be run in parallel:
/implement T008
/implement T009
/implement T013
/implement T016
```
