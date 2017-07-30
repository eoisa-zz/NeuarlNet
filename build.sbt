name := "NeuralNet"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.tensorflow" % "tensorflow" % "1.2.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % Test

//  change NeuralNet to ProofOfConcep_1 to run the proof of concept regarding the addition calculator
mainClass in (Compile, run) := Some("NeuralNet")