package com.github.leoamsbb.chess

import org.scalatest.prop.TableDrivenPropertyChecks._

class PawnSpec extends ChessSpec {
  describe("Pawn placed centrally") {
    it("should return correct possible positions when placed at D5") {
      verifyOutput(
        actual = Pawn("D5").possibleMoves,
        expected = List("E4", "E5", "E6"))
    }

    it("should return correct possible positions when placed at B7") {
      verifyOutput(
        actual = Pawn("B7").possibleMoves,
        expected = List("C6", "C7", "C8"))
    }
  }

  describe("Pawn placed at corners") {
    val pawnInCorners = Table(
      ("pawnsPosition", "expectedResult"),
      ("A1", List("B1", "B2")),
      ("A8", List("B7", "B8")),
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
    val pawnInCorners = Table(
      ("pawnsPosition", "expectedResult"),
      ("F1", List("G1", "G2")),
      ("A4", List("B3", "B4", "B5")),
      ("D8", List("E7", "E8")),
      ("H5", List.empty[String])
    )
    it("should return correct positions when placed on border lines") {
      forAll(pawnInCorners) { (pawnsPosition, expectedResult) => {
        verifyOutput(
          actual = Pawn(pawnsPosition).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }
}
