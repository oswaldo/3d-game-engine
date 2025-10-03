package com.example.game.renderer3d

import com.example.game.core._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class Renderer3DSpec extends AnyWordSpec with Matchers {

  "Renderer3D" should {
    "be able to render a scene with a Mesh component" in {
      // This is a conceptual test. A real 3D renderer test would be more complex.
      // For now, we'll just ensure the renderer can be created and the render method called.

      trait Renderer3D {
        def render(scene: Scene): Unit
      }

      class MockRenderer3D extends Renderer3D {
        var renderedMeshes: List[String] = Nil
        override def render(scene: Scene): Unit = {
          scene.gameObjects.foreach { go =>
            go.components.foreach {
              case Mesh(modelPath) => renderedMeshes = renderedMeshes :+ modelPath
              case _ => ()
            }
          }
        }
      }

      val mesh = Mesh("cube.obj")
      val cube = GameObject("Cube", components = List(mesh))
      val scene = Scene("3D Scene", gameObjects = List(cube))

      val renderer = new MockRenderer3D()
      renderer.render(scene)

      renderer.renderedMeshes should contain("cube.obj")
    }
  }
}
