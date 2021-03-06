import xml.Group

name := "scala3-sample-classes"

organization := "com.github.pjfanning"

scalaVersion := "3.0.0-M1" //downgrade due to https://github.com/scala/bug/issues/12255

organizationHomepage in ThisBuild := Some(url("https://github.com/pjfanning/scala3-sample-classes"))

scalacOptions in ThisBuild ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

publishMavenStyle in ThisBuild := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

Global / useGpg := false

publishTo := {
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("Sonatype Nexus Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

credentials in ThisBuild += Credentials (Path.userHome / ".ivy2" / ".credentials")

resolvers in ThisBuild ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("snapshots")
)

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

homepage := Some(new URL("https://github.com/pjfanning/scala3-sample-classes"))

parallelExecution in Test := false

startYear := Some(2020)

licenses := Seq(("Apache License 2.0", new URL("http://www.apache.org/licenses/LICENSE-2.0.html")))

releasePublishArtifactsAction := PgpKeys.publishSigned.value

pomExtra := {
  pomExtra.value ++ Group(
    <scm>
      <connection>scm:git:git@github.com:pjfanning/scala3-sample-classes.git</connection>
      <developerConnection>scm:git:git@github.com:pjfanning/scala3-sample-classes.git</developerConnection>
      <url>https://github.com/pjfanning/scala3-sample-classes</url>
    </scm>
      <issueManagement>
        <system>github</system>
        <url>https://github.com/pjfanning/scala3-sample-classes/issues</url>
      </issueManagement>
      <developers>
        <developer>
          <id>pjfanning</id>
          <name>PJ Fanning</name>
          <url>https://github.com/pjfanning</url>
        </developer>
      </developers>
  )
}

