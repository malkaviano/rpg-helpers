import Dependencies._

ThisBuild / scalaVersion := "2.13.7"
ThisBuild / version := "1.1.1"
ThisBuild / organization := "com.rkss"
ThisBuild / organizationName := "rkss"
ThisBuild / versionScheme := Some("early-semver")

ThisBuild / scalacOptions ++= Seq(
  "-encoding",
  "utf8",
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-feature",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Yrangepos",
  "-Xfatal-warnings"
)

lazy val root = (project in file("."))
  .settings(
    name := "rpg-helpers",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
