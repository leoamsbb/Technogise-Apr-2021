package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

import scala.reflect.ClassTag

class ChessPieceSpec extends FunSpec with Matchers {
  describe("ChessPiece Extraction") {

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

    it("should throw exception about usage when wrong input provided") {
      val exception = intercept[Exception]{val piece: ChessPiece = "chesspiece"}
      exception.getMessage shouldBe "Invalid input. Case matters. Usage: King D5"
    }

    def createAndVerify[T: ClassTag](input: String, expectedPosition: String): Unit = {
      val piece: ChessPiece = input
      piece shouldBe a[T]
      piece.current.toString shouldBe expectedPosition
    }
  }

  describe("ChessPiece Step") {
    it("should be Single for King and Pawn") {
      val chessPieces: List[ChessPiece] = List("King D2", "Pawn E6")
      all (chessPieces.map(_.step)) shouldBe Single
    }

    it("should be Default for Queen, Bishop, Rook") {
      val chessPieces: List[ChessPiece] = List("Queen B3", "Rook D5", "Bishop C4")
      all (chessPieces.map(_.step)) shouldBe Default
    }

    it("should be TwoAndHalf for Horse") {
      Horse("C6").step shouldBe TwoAndHalf
    }
  }

  describe("ChessPiece Direction") {
    it ("King and Queen can move in all directions") {
      King("A3").canMove should contain theSameElementsAs List(Vertical(), Horizontal(), Diagonal())
      Queen("A3").canMove should contain theSameElementsAs List(Vertical(), Horizontal(), Diagonal())
    }

    it("Bishop can move only Diagonally") {
      Bishop("C2").canMove should contain theSameElementsAs List(Diagonal())
    }

    it("Horse and Rook can move Vertically and Horizontally") {
      Horse("H2").canMove should contain theSameElementsAs List(Vertical(), Horizontal())
      Rook("D2").canMove should contain theSameElementsAs List(Vertical(), Horizontal())
    }
}
