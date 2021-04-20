package com.github.leoamsbb.chess

import org.scalatest.Matchers

trait ChessSpec extends Matchers {
  def verifyOutput(actual: List[Position], expected: List[String]) = {
    actual.map(_.toString) should contain theSameElementsAs expected
  }
}
