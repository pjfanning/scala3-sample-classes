package com.github.pjfanning.scala3

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class InstanceCreationSpec extends AnyWordSpec with Matchers {
  "InstanceCreation" must {
    "support EnclosingObject" in {
      EnclosingObject.EnclosedScala3Class("test", None) must not be (null)
    }
  }
}
