ThisBuild / scalaVersion     := "3.2.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scala3quill",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.3",
      "dev.zio" %% "zio-test" % "2.0.3" % Test,
      "io.getquill" %% "quill-cassandra-zio" % "4.6.0"
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
