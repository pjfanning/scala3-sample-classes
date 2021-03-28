package com.github.pjfanning.scala3

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

import scala.annotation.tailrec

class TastySpec extends AnyWordSpec with Matchers {
  private val specClass = classOf[TastySpec]

  "TastyUtil" must {
    "support Scala3Class" in {
      hasTastyFile(classOf[Scala3Class]) mustBe true
    }
    "support Scala3CaseClass" in {
      hasTastyFile(classOf[Scala3CaseClass]) mustBe true
    }
    "support Scala3Object" in {
      hasTastyFile(Scala3Object.getClass) mustBe true
    }
    "support Scala3CaseObject" in {
      hasTastyFile(Scala3CaseObject.getClass) mustBe true
    }
    "support ColorEnum" in {
      hasTastyFile(ColorEnum.getClass) mustBe true
    }
    "support JavaCompatibleColorEnum" in {
      hasTastyFile(JavaCompatibleColorEnum.getClass) mustBe true
    }
    "support EnclosingObject.EnclosedScala3Class" in {
      hasTastyFile(classOf[EnclosingObject.EnclosedScala3Class]) mustBe true
    }
    "support EnclosingObject.EnclosedColorEnum" in {
      hasTastyFile(EnclosingObject.EnclosedColorEnum.getClass) mustBe true
    }
    "not support Java class" in {
      hasTastyFile(classOf[String]) mustBe false
    }
  }

  @tailrec
  private def hasTastyFile(clz: Class[_]): Boolean = {
    clz != null && clz.getCanonicalName != null && {
      val baseName = clz.getCanonicalName.replace(".", "/")
      val classFileBase = if (baseName.endsWith("$")) {
        baseName.substring(0, baseName.length - 1)
      } else {
        baseName
      }
      val tastyFile = s"/$classFileBase.tasty"
      Option(specClass.getResource(tastyFile)).isDefined || hasTastyFile(clz.getEnclosingClass)
    }
  }
}
