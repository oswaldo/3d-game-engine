import sbt.*

object Dependencies {

  // define versions, The variable name must be camel case by module name
  object Versions {
    val lwjglVersion = "3.3.6"
    val scalafxVersion = "24.0.2-R36"
    val scalatestVersion = "3.2.19"
    val openjfxVersion = "24.0.2" // Added for JFXPanel in tests
  }

  object Compile {
    val lwjglDependencies = Seq(
      "org.lwjgl" % "lwjgl" % Versions.lwjglVersion,
      "org.lwjgl" % "lwjgl-glfw" % Versions.lwjglVersion,
      "org.lwjgl" % "lwjgl-opengl" % Versions.lwjglVersion,
      "org.lwjgl" % "lwjgl-stb" % Versions.lwjglVersion,
      "org.lwjgl" % "lwjgl" % Versions.lwjglVersion classifier "natives-windows",
      "org.lwjgl" % "lwjgl-glfw" % Versions.lwjglVersion classifier "natives-windows",
      "org.lwjgl" % "lwjgl-opengl" % Versions.lwjglVersion classifier "natives-windows",
      "org.lwjgl" % "lwjgl-stb" % Versions.lwjglVersion classifier "natives-windows",
      "org.lwjgl" % "lwjgl" % Versions.lwjglVersion classifier "natives-linux",
      "org.lwjgl" % "lwjgl-glfw" % Versions.lwjglVersion classifier "natives-linux",
      "org.lwjgl" % "lwjgl-opengl" % Versions.lwjglVersion classifier "natives-linux",
      "org.lwjgl" % "lwjgl-stb" % Versions.lwjglVersion classifier "natives-linux",
      "org.lwjgl" % "lwjgl" % Versions.lwjglVersion classifier "natives-macos",
      "org.lwjgl" % "lwjgl-glfw" % Versions.lwjglVersion classifier "natives-macos",
      "org.lwjgl" % "lwjgl-opengl" % Versions.lwjglVersion classifier "natives-macos",
      "org.lwjgl" % "lwjgl-stb" % Versions.lwjglVersion classifier "natives-macos"
    )
    val scalafxDependencies = Seq(
      "org.scalafx" %% "scalafx" % Versions.scalafxVersion
    )
  }

  object Test {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalatestVersion % "test"
    val javafxSwing: ModuleID = "org.openjfx" % "javafx-swing" % Versions.openjfxVersion % "test"
  }

  import Compile.*
  import Test.*

  lazy val dependencies2d: Seq[ModuleID] = scalafxDependencies ++ Seq(scalaTest, javafxSwing)
  lazy val dependencies3d: Seq[ModuleID] = lwjglDependencies ++ Seq(scalaTest)

}