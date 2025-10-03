ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "3d",
    libraryDependencies ++= Seq(
      // For 2D menus and UI
      "org.scalafx" %% "scalafx" % "21.0.0-R30"
    ),
    // Define the main class for the application
    mainClass := Some("com.example.game.Main"), // Placeholder, user will define this later
    // Fork a new JVM for running the application, necessary for ScalaFX
    fork := true
  )
