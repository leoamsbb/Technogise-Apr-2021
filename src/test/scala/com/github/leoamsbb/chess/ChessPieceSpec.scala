package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

import scala.reflect.ClassTag

class ChessPieceSpec extends FunSpec with Matchers {
  describe("ChessPiece") {

    it ("should extract King and current position from String") {
      createAndVerify[King]("King D5", "D5")
    }

    it ("should extract Horse and current position from String") {
      createAndVerify[Horse]("Horse A2", "A2")
    }

    it ("should extract Queen and current position from String") {
      createAndVerify[Queen]("Queen B3", "B3")
    }

    it("should extract Bishop and current position from String") {
      createAndVerify[Bishop]("Bishop C4", "C4")
    }

    it("should extract Rook and current position from String") {
      createAndVerify[Rook]("Rook D5", "D5")
    }

    it("should extract Pawn and current position from String") {
      createAndVerify[Pawn]("Pawn E6", "E6")
    }

    def createAndVerify[T: ClassTag](input: String, expectedPosition: String): Unit = {
      val piece: ChessPiece = input
      piece shouldBe a[T]
      piece.current.toString shouldBe expectedPosition
    }
  }
}
