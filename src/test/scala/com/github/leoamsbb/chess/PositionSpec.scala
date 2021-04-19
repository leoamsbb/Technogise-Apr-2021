package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

class PositionSpec extends FunSpec with Matchers {

  describe("Position Extraction") {
    it("should be able to separate String into row and column type") {
      val pos: Position = "D3"
      pos.row shouldBe 'D'
      pos.column shouldBe 3
    }

    it("display position in proper output format") {
      val pos: Position = Position('C', 4)
      pos.toString shouldBe "C4"
    }
  }

  describe("Position Mathematics") {
    it("should return position from next row and same column") {
      val position:Position = "D3"
      position.increaseRow.toString shouldBe "E3"
    }

    it("should return position from previous row and same column") {
      val position:Position = "D3"
      position.decreaseRow.toString shouldBe "C3"
    }

    it("should return position from same row but next column") {
      val position:Position = "D3"
      position.increaseColumn.toString shouldBe "D4"
    }

    it("should return position from same row but previous column") {
      val position:Position = "D3"
      position.decreaseColumn.toString shouldBe "D2"
    }
  }
}
