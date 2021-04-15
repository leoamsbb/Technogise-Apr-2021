package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

class PositionSpec extends FunSpec with Matchers {

  describe("Position") {
    it("should be able to separate String into row and column type") {
      val pos: Position = "D3"
      pos.row shouldBe 'D'
      pos.col shouldBe 3
    }

    it("display position in proper output format") {
      val pos: Position = Position('C', 4)
      pos.toString shouldBe "C4"
    }
  }
}
