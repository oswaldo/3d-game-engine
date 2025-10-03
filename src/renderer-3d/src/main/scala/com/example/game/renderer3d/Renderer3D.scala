package com.example.game.renderer3d

import com.example.game.core.Scene
import org.lwjgl.glfw.GLFW._
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11._
import org.lwjgl.system.MemoryUtil

class Renderer3D {

  private var window: Long = 0

  def init(): Unit = {
    if (!glfwInit()) {
      throw new IllegalStateException("Unable to initialize GLFW")
    }

    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

    window = glfwCreateWindow(800, 600, "3D Game Engine", MemoryUtil.NULL, MemoryUtil.NULL)
    if (window == MemoryUtil.NULL) {
      throw new RuntimeException("Failed to create the GLFW window")
    }

    glfwMakeContextCurrent(window)
    glfwSwapInterval(1) // Enable v-sync
    glfwShowWindow(window)

    GL.createCapabilities()
    glClearColor(0.1f, 0.2f, 0.3f, 0.0f);
  }

  def render(scene: Scene): Unit = {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    // TODO: Scene graph traversal and rendering logic will go here.
    // For each object with a Mesh component, load the model and render it.

    glfwSwapBuffers(window)
    glfwPollEvents()
  }

  def cleanup(): Unit = {
    glfwDestroyWindow(window)
    glfwTerminate()
  }

  def windowShouldClose: Boolean = {
    glfwWindowShouldClose(window)
  }
}
