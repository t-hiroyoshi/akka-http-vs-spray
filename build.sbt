lazy val commonSettings = Seq(
  name := "akka-http-vs-spray",
  version := "1.0.0",
  scalaVersion := "2.11.8",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint")
)

val akkaV = "2.4.4"
val sprayV = "1.3.3"

lazy val spraySettings = Seq(
  libraryDependencies ++= {
    Seq(
      "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
      "io.spray"            %%  "spray-can"     % sprayV,
      "io.spray"            %%  "spray-routing" % sprayV
    )
  }
)

lazy val akkaSettings = Seq(
  libraryDependencies ++= {
    Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaV,
      "com.typesafe.akka" %% "akka-stream" % akkaV,
      "com.typesafe.akka" %% "akka-http-experimental" % akkaV
    )
  }
)

lazy val sprayServer = (project in file("spray-server"))
.settings(commonSettings: _*)
.settings(spraySettings: _*)
.settings(assemblyOutputPath in assembly := file("./spray-server.jar"))

lazy val akkaServer = (project in file("akka-server"))
.settings(commonSettings: _*)
.settings(akkaSettings: _*)
.settings(assemblyOutputPath in assembly := file("./akka-server.jar"))

Revolver.settings
