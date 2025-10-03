# Implementation Plan: Game Engine Core

**Branch**: `001-game-engine-core` | **Date**: 2024-05-22 | **Spec**: [spec.md](./spec.md)
**Input**: Feature specification from `/specs/001-game-engine-core/spec.md`

## Execution Flow (/plan command scope)
```
1. Load feature spec from Input path
   → If not found: ERROR "No feature spec at {path}"
2. Fill Technical Context (scan for NEEDS CLARIFICATION)
   → Detect Project Type from file system structure or context (web=frontend+backend, mobile=app+api)
   → Set Structure Decision based on project type
3. Fill the Constitution Check section based on the content of the constitution document.
4. Evaluate Constitution Check section below
   → If violations exist: Document in Complexity Tracking
   → If no justification possible: ERROR "Simplify approach first"
   → Update Progress Tracking: Initial Constitution Check
5. Execute Phase 0 → research.md
   → If NEEDS CLARIFICATION remain: ERROR "Resolve unknowns"
6. Execute Phase 1 → contracts, data-model.md, quickstart.md, agent-specific template file (e.g., `CLAUDE.md` for Claude Code, `.github/copilot-instructions.md` for GitHub Copilot, `GEMINI.md` for Gemini CLI, `QWEN.md` for Qwen Code, or `AGENTS.md` for all other agents).
7. Re-evaluate Constitution Check section
   → If new violations: Refactor design, return to Phase 1
   → Update Progress Tracking: Post-Design Constitution Check
8. Plan Phase 2 → Describe task generation approach (DO NOT create tasks.md)
9. STOP - Ready for /tasks command
```

## Summary
This plan details the implementation of a simple, modular game engine in pure Scala, supporting 2D menus, 2D and 3D environments. It targets mid-range performance on modern hardware across desktop, mobile, and web platforms, adhering to the project's constitutional principles.

## Technical Context
**Language/Version**: Scala 3.7.3
**Primary Dependencies**: ScalaFX (for 2D UI and 2D rendering), LWJGL (for 3D rendering)
**Storage**: N/A
**Testing**: ScalaTest
**Target Platform**: Desktop (Windows, macOS, Linux), Mobile (Android, iOS), Web (via Scala.js)
**Project Type**: Single project with multiple modules (core, ui, renderer-2d, renderer-3d)
**Performance Goals**: Mid-range performance for indie games.
**Constraints**: Must be written in pure Scala, with minimal dependencies and an immutable-by-default architecture.
**Scale/Scope**: A simple engine, not a feature-complete commercial engine.

## Constitution Check
*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

- [X] **I. Pure Scala**: The engine will be written in Scala, leveraging ScalaFX and LWJGL with Scala wrappers.
- [X] **II. Modularity**: The project is structured into core, ui, renderer-2d, and renderer-3d modules.
- [X] **III. Immutability by Default**: The data model emphasizes immutable data structures.
- [X] **IV. Type-Driven Development**: The data model and APIs are designed with Scala's type system in mind.
- [X] **V. Lightweight and Minimal Dependencies**: ScalaFX is already used for UI, and LWJGL is a performant, low-level choice for 3D. No additional heavy dependencies are introduced.

## Project Structure

### Documentation (this feature)
```
specs/001-game-engine-core/
├── plan.md              # This file (/plan command output)
├── research.md          # Phase 0 output (/plan command)
├── data-model.md        # Phase 1 output (/plan command)
├── quickstart.md        # Phase 1 output (/plan command)
├── contracts/
│   └── API.md           # Phase 1 output (/plan command)
└── tasks.md             # Phase 2 output (/tasks command - NOT created by /plan)
```

### Source Code (repository root)
```
src/
├── core/
│   ├── src/main/scala/com/example/game/core/
│   └── src/test/scala/com/example/game/core/
├── ui/
│   ├── src/main/scala/com/example/game/ui/
│   └── src/test/scala/com/example/game/ui/
├── renderer-2d/
│   ├── src/main/scala/com/example/game/renderer2d/
│   └── src/test/scala/com/example/game/renderer2d/
└── renderer-3d/
    ├── src/main/scala/com/example/game/renderer3d/
    └── src/test/scala/com/example/game/renderer3d/
```

**Structure Decision**: A multi-module structure will be used to enforce the modularity principle of the constitution. Each module will be a separate sbt project.

## Phase 0: Outline & Research
1. **Extract unknowns from Technical Context** above:
   - Research and select a 3D rendering library for Scala that is lightweight and can target desktop, mobile and web. (Resolved: LWJGL)
   - Research and select a 2D rendering library for Scala that integrates well with ScalaFX and can be used for game environments. (Resolved: ScalaFX Canvas API)

2. **Generate and dispatch research agents**:
   - (Completed, documented in research.md)

3. **Consolidate findings** in `research.md` using format:
   - (Completed, documented in research.md)

**Output**: research.md with all NEEDS CLARIFICATION resolved

## Phase 1: Design & Contracts
*Prerequisites: research.md complete*

1. **Extract entities from feature spec** → `data-model.md`:
   - Define the data models for Scene, GameObject, and Component using Scala case classes and sealed traits. (Completed, documented in data-model.md)

2. **Generate API contracts** from functional requirements:
   - Define the public API for the engine, focusing on simplicity and ease of use. This will be a programmatic API, not a network API. (Completed, documented in contracts/API.md)

3. **Generate contract tests** from contracts:
   - Create unit tests for the public API to ensure it behaves as expected. (To be done in Phase 2)

4. **Extract test scenarios** from user stories:
   - Create integration tests that simulate the user stories, such as creating a menu and loading a 2D/3D scene. (To be done in Phase 2)

5. **Update agent file incrementally** (O(1) operation):
   - Run `.specify/scripts/bash/update-agent-context.sh gemini` (To be done)

**Output**: data-model.md, /contracts/*, failing tests, quickstart.md, agent-specific file

## Phase 2: Task Planning Approach
*This section describes what the /tasks command will do - DO NOT execute during /plan*

**Task Generation Strategy**:
- Load `.specify/templates/tasks-template.md` as base
- Generate tasks from Phase 1 design docs (contracts, data model, quickstart)
- Each data model → a task to create the case classes and sealed traits.
- Each API function → a task to implement the function and its unit test.
- Each user story → an integration test task.

**Ordering Strategy**:
- TDD order: Tests before implementation 
- Dependency order: core module, then rendering and UI modules.
- Mark [P] for parallel execution (independent files)

**Estimated Output**: 25-30 numbered, ordered tasks in tasks.md

## Phase 3+: Future Implementation
*These phases are beyond the scope of the /plan command*

**Phase 3**: Task execution (/tasks command creates tasks.md)  
**Phase 4**: Implementation (execute tasks.md following constitutional principles)  
**Phase 5**: Validation (run tests, execute quickstart.md, performance validation)

## Complexity Tracking
*Fill ONLY if Constitution Check has violations that must be justified*

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
|           |            |                                     |

## Progress Tracking
*This checklist is updated during execution flow*

**Phase Status**:
- [X] Phase 0: Research complete (/plan command)
- [X] Phase 1: Design complete (/plan command)
- [ ] Phase 2: Task planning complete (/plan command - describe approach only)
- [ ] Phase 3: Tasks generated (/tasks command)
- [ ] Phase 4: Implementation complete
- [ ] Phase 5: Validation passed

**Gate Status**:
- [X] Initial Constitution Check: PASS
- [X] Post-Design Constitution Check: PASS
- [X] All NEEDS CLARIFICATION resolved
- [ ] Complexity deviations documented

---
*Based on Constitution v1.0.0 - See `/.specify/memory/constitution.md`*
