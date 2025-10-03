ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.7.3"



lazy val core = (project in file("src/core"))
  .settings(
    name := "core",
    libraryDependencies += Dependencies.Test.scalaTest
  )

lazy val ui = (project in file("src/ui"))
  .dependsOn(core)
  .settings(
    name := "ui",
    libraryDependencies ++= Dependencies.dependencies2d,
  )

lazy val renderer2d = (project in file("src/renderer-2d"))
  .dependsOn(core)
  .settings(
    name := "renderer-2d",
    libraryDependencies ++= Dependencies.dependencies2d,
  )

lazy val renderer3d = (project in file("src/renderer-3d"))
  .dependsOn(core)
  .settings(
    name := "renderer-3d",
    libraryDependencies ++= Dependencies.dependencies3d,
  )

lazy val root = (project in file("."))
  .settings(
    name := "3d-game-engine",
    mainClass := Some("com.example.game.Main"),
    fork := true,
    libraryDependencies ++= Dependencies.dependencies2d,
  )
  .aggregate(core, ui, renderer2d, renderer3d)
  .dependsOn(core, ui, renderer2d, renderer3d)
