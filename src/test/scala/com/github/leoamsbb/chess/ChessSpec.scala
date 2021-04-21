package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

trait ChessSpec extends FunSpec with Matchers {
  def verifyOutput(actual: List[Position], expected: List[String]) = {
    actual.map(_.toString) should contain theSameElementsAs expected
  }
}
