package com.github.leoamsbb.chess

import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class HorseSpec extends FunSpec with ChessSpec {

  describe("Horse placed within board") {
    it("should return correct position when placed at E3") {
      verifyOutput(
        actual = Horse("E3").possibleMoves,
        expected = List(
          "G2", "G4", "F1", "F5",
          "D1", "D5", "C2", "C4"
        )
      )
    }

    it("should return correct position when placed at C6") {
      verifyOutput(
        actual = Horse("C6").possibleMoves,
        expected = List(
          "E5", "E7", "D4", "D8",
          "A5", "A7", "B4", "B8"
        )
      )
    }
  }

  describe("Horse placed on corners") {
    val horseOnCorners = Table(
      ("position", "expectedResult"),
      ("H1", List("F2", "G3")),
      ("H8", List("G6", "F7")),
      ("A1", List("C2", "B3")),
      ("A8", List("C7", "B6"))
    )

    it("should return correct position when placed at corners") {
      forAll(horseOnCorners) { (position, expectedResult) => {
        verifyOutput(
          actual = Horse(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }

  describe("Horse placed on borders") {
    val horseOnCorners = Table(
      ("position", "expectedResult"),
      ("E1", List("F3", "D3", "C2", "G2")),
      ("A3", List("B1", "B5", "C2", "C4")),
      ("E8", List("G7", "C7", "F6", "D6")),
      ("H5", List("G3", "G7", "F4", "F6"))
    )

    it("should return correct position when placed on borders") {
      forAll(horseOnCorners) { (position, expectedResult) => {
        verifyOutput(
          actual = Horse(position).possibleMoves,
          expected = expectedResult
        )
      }
      }
    }
  }
}
