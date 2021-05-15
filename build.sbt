import xml.Group

name := "scala3-sample-classes"

organization := "com.github.pjfanning"

scalaVersion := "3.0.0"

ThisBuild / organizationHomepage := Some(url("https://github.com/pjfanning/scala3-sample-classes"))

ThisBuild / scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

publishMavenStyle := true

Test / publishArtifact := false

pomIncludeRepository := { x => false }

publishTo := {
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("Sonatype Nexus Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

ThisBuild / credentials += Credentials (Path.userHome / ".ivy2" / ".credentials")

ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("snapshots")
)


homepage := Some(new URL("https://github.com/pjfanning/scala3-sample-classes"))

Test / parallelExecution := false

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

