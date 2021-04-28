package com.github.leoamsbb.chess

import org.scalatest.prop.TableDrivenPropertyChecks._

class KingSpec extends ChessSpec {
  describe("King placed centrally") {
    it("should return correct possible positions when placed at D5") {
      verifyOutput(
        actual = King("D5").possiblePositions,
        expected = List(
          "E4", "E5", "E6",
          "D4", "D6",
          "C4", "C5", "C6"))
    }

    it("should return correct possible positions when placed at B7") {
      verifyOutput(
        actual = King("B7").possiblePositions,
        expected = List(
          "A6", "A7", "A8",
          "B6", "B8",
          "C6", "C7", "C8"))
    }
  }

  describe("King placed at corners") {
    val kingInCorners = Table(
      ("kingsPosition", "expectedResult"),
      ("A1", List("B1", "B2", "A2")),
      ("A8", List("B7", "B8", "A7")),
      ("H8", List("G7", "G8", "H7")),
      ("H1", List("G1", "G2", "H2"))
    )
    it("should return correct positions when placed at corner") {
      forAll(kingInCorners) { (kingsPosition, expectedResult) => {
        verifyOutput(
          actual = King(kingsPosition).possiblePositions,
          expected = expectedResult
        )
      }
      }
    }
  }

  describe("King placed on border lines") {
    val kingInCorners = Table(
      ("kingsPosition", "expectedResult"),
      ("F1", List("G1", "G2", "F2", "E2", "E1")),
      ("A4", List("A3", "B3", "B4", "B5", "A5")),
      ("D8", List("E7", "E8", "C7", "D7", "C8")),
      ("H5", List("H4", "G4", "G5", "G6", "H6"))
    )
    it("should return correct positions when placed on border lines") {
      forAll(kingInCorners) { (kingsPosition, expectedResult) => {
        verifyOutput(
          actual = King(kingsPosition).possiblePositions,
          expected = expectedResult
        )
      }
      }
    }
  }
}
