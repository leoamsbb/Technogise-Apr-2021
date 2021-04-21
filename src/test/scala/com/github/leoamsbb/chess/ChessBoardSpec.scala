package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.ChessBoard.{outsideBoard, withinBoard}
import org.scalatest.{FunSpec, Matchers}

class ChessBoardSpec extends FunSpec with Matchers {

  describe("withinBoard") {
    it("should return true when the given position is inside board") {
      withinBoard("D3") shouldBe true
    }

    it("should return false when the given position is outside board") {
      withinBoard(Position('H', 0)) shouldBe false
    }
  }

  describe("outsideBoard") {
    it("should return true when the given position is outside board") {
      outsideBoard(Position('A', 9)) shouldBe true
    }

    it("should return false when the given position is inside board") {
      outsideBoard("A2") shouldBe false
    }
  }
}
