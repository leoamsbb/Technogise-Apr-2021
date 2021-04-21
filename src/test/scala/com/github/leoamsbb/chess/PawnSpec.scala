package com.github.leoamsbb.chess

import org.scalatest.prop.TableDrivenPropertyChecks._

class PawnSpec extends ChessSpec {
  describe("Pawn placed centrally") {
    it("should return correct possible positions when placed at D5") {
      verifyOutput(
        actual = Pawn("D5").possibleMoves,
        expected = List("E5"))
    }

    it("should return correct possible positions when placed at B7") {
      verifyOutput(
        actual = Pawn("B7").possibleMoves,
        expected = List("C7"))
    }
  }

  describe("Pawn placed at corners") {
    val pawnInCorners = Table(
      ("pawnsPosition", "expectedResult"),
      ("A1", List("B1")),
      ("A8", List("B8")),
      ("H8", List.empty[String]),
      ("H1", List.empty[String])
    )
    it("should return correct positions when placed at corner") {
      forAll(pawnInCorners) { (pawnsPosition, expectedResult) => {
        verifyOutput(
          actual = Pawn(pawnsPosition).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }

  describe("Pawn placed on border lines") {
    val pawnOnBorders = Table(
      ("pawnsPosition", "expectedResult"),
      ("F1", List("G1")),
      ("A4", List("B4")),
      ("D8", List("E8")),
      ("H5", List.empty[String])
    )
    it("should return correct positions when placed on border lines") {
      forAll(pawnOnBorders) { (pawnsPosition, expectedResult) => {
        verifyOutput(
          actual = Pawn(pawnsPosition).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }
}
