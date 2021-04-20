package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

class StepSpec extends FunSpec with Matchers {

  val vertical = Vertical()
  val horizontal = Horizontal()
  val diagonal = Diagonal()

  describe("Single Step") {
    it("should return correct position when taken in vertical forward direction") {
      verifyOutput(Single.advance("D5", vertical), List("E5"))
    }
    it("should return correct position when taken in vertical backward direction") {
      verifyOutput(Single.retreat("D5", vertical), List("C5"))
    }

    it("should return correct position when taken in horizontal forward direction") {
      verifyOutput(Single.advance("D5", horizontal), List("D6"))
    }
    it("should return correct position when taken in horizontal backward direction") {
      verifyOutput(Single.retreat("D5", horizontal), List("D4"))
    }

    it("should return correct position when taken in diagonal forward direction") {
      verifyOutput(Single.advance("D5", diagonal), List("E4", "E6"))
    }
    it("should return correct position when taken in diagonal backward direction") {
      verifyOutput(Single.retreat("D5", diagonal), List("C4", "C6"))
    }
  }

  describe("Two and Half Step") {
    it("should return correct position when taken in vertical forward direction") {
      verifyOutput(TwoAndHalf.advance("E3", vertical), List("G2", "G4"))
    }
    it("should return correct position when taken in vertical backward direction") {
      verifyOutput(TwoAndHalf.retreat("E3", vertical), List("C2", "C4"))
    }

    it("should return correct position when taken in horizontal forward direction") {
      verifyOutput(TwoAndHalf.advance("E3", horizontal), List("F5", "D5"))
    }
    it("should return correct position when taken in horizontal backward direction") {
      verifyOutput(TwoAndHalf.retreat("E3", horizontal), List("F1", "D1"))
    }

    it("should return empty list when taken in either diagonal direction") {
      TwoAndHalf.advance("E3", diagonal) shouldBe empty
      TwoAndHalf.retreat("E3", diagonal) shouldBe empty
    }
  }

  describe("Default Step : Entire Row, Column & Diagonal") {
    it("should return correct position when taken in vertical forward direction") {
      verifyOutput(Default.advance("F3", vertical), List("G3", "H3"))
    }
    it("should return correct position when taken in vertical backward direction") {
      verifyOutput(Default.retreat("F3", vertical), List("A3", "B3", "C3", "D3", "E3"))
    }

    it("should return correct position when taken in horizontal forward direction") {
      verifyOutput(Default.advance("F3", horizontal), List("F4", "F5", "F6", "F7", "F8"))
    }
    it("should return correct position when taken in horizontal backward direction") {
      verifyOutput(Default.retreat("F3", horizontal), List("F1", "F2"))
    }

    it("should return correct position when taken in diagonal forward direction") {
      verifyOutput(Default.advance("F3", diagonal), List("H1", "G2", "G4", "H5"))
    }
    it("should return correct position when taken in diagonal backward direction") {
      verifyOutput(Default.retreat("F3", diagonal), List("D1", "E2", "E4", "D5", "C6", "B7", "A8"))
    }
  }
  private def verifyOutput(actual: List[Position], expected: List[String]): Unit = {
    actual.map(_.toString) should contain theSameElementsAs expected
  }
}
