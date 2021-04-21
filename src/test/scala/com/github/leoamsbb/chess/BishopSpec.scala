package com.github.leoamsbb.chess

import org.scalatest.prop.TableDrivenPropertyChecks._

class BishopSpec extends ChessSpec {

  describe("Bishop placed within board") {
    it("should return correct position when placed at E3") {
      verifyOutput(
        actual = Bishop("E3").possibleMoves,
        expected = List(
          "C1", "D2", "F4", "G5", "H6",
          "F2", "G1", "D4", "C5", "B6", "A7"
        )
      )
    }

    it("should return correct position when placed at C6") {
      verifyOutput(
        actual = Bishop("C6").possibleMoves,
        expected = List(
          "B7", "A8", "D5", "E4", "F3", "G2", "H1",
          "B5", "D7", "A4", "E8"
        )
      )
    }
  }

  describe("Bishop placed on corners") {
    val bishopOnCorners = Table(
      ("position", "expectedResult"),
      ("H1", List("A8", "B7", "C6", "D5", "E4", "F3", "G2")),
      ("H8", List("A1", "B2", "C3", "D4", "E5", "F6", "G7")),
      ("A1", List("B2", "C3", "D4", "E5", "F6", "G7", "H8")),
      ("A8", List("B7", "C6", "D5", "E4", "F3", "G2", "H1"))
    )

    it("should return correct position when placed at corners") {
      forAll(bishopOnCorners) { (position, expectedResult) => {
        verifyOutput(
          actual = Bishop(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }

  describe("Bishop placed on borders") {
    val horseOnCorners = Table(
      ("position", "expectedResult"),
      ("E1", List("F2", "G3", "H4", "D2", "C3", "B4", "A5")),
      ("A3", List("C1", "B2", "B4", "C5", "D6", "E7", "F8")),
      ("E8", List("A4", "B5", "C6", "D7", "F7", "G6", "H5")),
      ("H5", List("D1", "E2", "F3", "G4", "E8", "F7", "G6"))
    )

    it("should return correct position when placed on borders") {
      forAll(horseOnCorners) { (position, expectedResult) => {
        verifyOutput(
          actual = Bishop(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }
}
