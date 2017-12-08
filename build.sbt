name := "sparkTest"

version := "0.1"

scalaVersion := "2.11.5"


libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-catalyst" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0"

libraryDependencies += "org.mongodb" %% "casbah" % "3.1.1" pomOnly()

// https://mvnrepository.com/artifact/org.apache.kafka/kafka
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.11.0.2"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.8"
