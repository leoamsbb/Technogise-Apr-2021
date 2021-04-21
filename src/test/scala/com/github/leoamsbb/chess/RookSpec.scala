package com.github.leoamsbb.chess

import org.scalatest.prop.TableDrivenPropertyChecks._

class RookSpec extends ChessSpec {
  describe("Rook placed centrally") {
    it("should return correct possible positions when placed at E3") {
      verifyOutput(
        actual = Rook("E3").possibleMoves,
        expected = List(
          "F3", "G3", "H3",
          "A3", "B3", "C3", "D3",
          "E1", "E2",
          "E4", "E5", "E6", "E7", "E8"
        )
      )
    }

    it("should return correct possible positions when placed at C2") {
      verifyOutput(
        actual = Rook("C2").possibleMoves,
        expected = List(
          "A2", "B2",
          "D2", "E2", "F2", "G2", "H2",
          "C1",
          "C3", "C4", "C5", "C6", "C7", "C8"
        )
      )
    }
  }

  describe("Rook placed on corners") {
    val queenOnCorners = Table(
      ("position", "expectedResult"),
      ("H1",
        List(
          "A1", "B1", "C1", "D1", "E1", "F1", "G1",
          "H2", "H3", "H4", "H5", "H6", "H7", "H8"
        )
      ),
      ("H8",
        List(
          "H2", "H3", "H4", "H5", "H6", "H7", "H1",
          "A8", "B8", "C8", "D8", "E8", "F8", "G8"
        )
      ),
      ("A1",
        List(
          "B1", "C1", "D1", "E1", "F1", "G1", "H1",
          "A2", "A3", "A4", "A5", "A6", "A7", "A8"
        )
      ),
      ("A8",
        List(
          "A1", "A2", "A3", "A4", "A5", "A6", "A7",
          "B8", "C8", "D8", "E8", "F8", "G8", "H8"
        )
      )
    )

    it("should return correct position when placed at corners") {
      forAll(queenOnCorners) { (position, expectedResult) => {
        verifyOutput(
          actual = Rook(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }

  describe("Rook when placed on borders") {
    val queenOnBorder = Table(
      ("position", "expectedResult"),
      ("E1",
        List(
          "A1", "B1", "C1", "D1", "F1", "G1", "H1",
          "E2", "E3", "E4", "E5", "E6", "E7", "E8"
        )
      ),
      ("A2",
        List(
          "A1", "A3", "A4", "A5", "A6", "A7", "A8",
          "B2", "C2", "D2", "E2", "F2", "G2", "H2"
        )
      ),
      ("D8",
        List(
          "A8", "B8", "C8", "E8", "F8", "G8", "H8",
          "D1", "D2", "D3", "D4", "D5", "D6", "D7"
        )
      ),
      ("H3",
        List(
          "H1", "H2", "H4", "H5", "H6", "H7", "H8",
          "A3", "B3", "C3", "D3", "E3", "F3", "G3"
        )
      )
    )

    it("should return correct position when placed on borders") {
      forAll(queenOnBorder) { (position, expectedResult) => {
        verifyOutput(
          actual = Rook(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }
}
