package com.github.leoamsbb.chess

import org.scalatest.{Assertion, FunSpec, Matchers}

trait ChessSpec extends FunSpec with Matchers {
  def verifyOutput(actual: List[Position], expected: List[String]): Assertion = {
    actual.map(_.toString) should contain theSameElementsAs expected
  }
}
