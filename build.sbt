name := "chuckdave"

organization := "com.example"

version := "0.0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.itv.chuckwagon" %% "chuckwagon-jvm" % "0.1.3"
)

enablePlugins(ChuckwagonPublishPlugin)

chuckRegion := "eu-west-1"
chuckPublishConfig := chuckPublishConfigBuilder
  .withName("Chuck-Dave")
  .withHandler("com.example.chuckdave.HelloWorld::handleRequest")
  .withMemorySizeInMB(192)
  .withTimeout("5 seconds")
  .withStagingBucketName("chuckdave")
  .withCodeFile(assembly)
  .withRoleARN("arn:aws:iam::586133794935:role/dev_iam_profile_lambda_execute-default_role")

