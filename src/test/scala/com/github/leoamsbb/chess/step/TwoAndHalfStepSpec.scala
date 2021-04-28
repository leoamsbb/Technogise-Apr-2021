package com.github.leoamsbb.chess.step

class TwoAndHalfStepSpec extends StepSpec {
  it("should return correct position when taken in vertical forward direction") {
    verifyOutput(TwoAndHalf.advance("E3", vertical), List("G2", "G4"))
  }
  it("should return correct position when taken in vertical backward direction") {
    verifyOutput(TwoAndHalf.retreat("E3", vertical), List("C2", "C4"))
  }
  it("should return empty list when forward or backward is disabled for vertical direction") {
    TwoAndHalf.advance("D5", vertical.copy(forward = false)) shouldBe empty
    TwoAndHalf.advance("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
    TwoAndHalf.retreat("D5", vertical.copy(backward = false)) shouldBe empty
    TwoAndHalf.retreat("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return correct position when taken in horizontal forward direction") {
    verifyOutput(TwoAndHalf.advance("E3", horizontal), List("F5", "D5"))
  }
  it("should return correct position when taken in horizontal backward direction") {
    verifyOutput(TwoAndHalf.retreat("E3", horizontal), List("F1", "D1"))
  }
  it("should return empty list when forward or backward is disabled for horizontal direction") {
    TwoAndHalf.advance("D5", horizontal.copy(forward = false)) shouldBe empty
    TwoAndHalf.advance("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
    TwoAndHalf.retreat("D5", horizontal.copy(backward = false)) shouldBe empty
    TwoAndHalf.retreat("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return empty list when taken in either diagonal direction") {
    TwoAndHalf.advance("E3", diagonal) shouldBe empty
    TwoAndHalf.retreat("E3", diagonal) shouldBe empty
    TwoAndHalf.advance("E3", diagonal.copy(forward = false)) shouldBe empty
    TwoAndHalf.advance("E3", diagonal.copy(forward = false, backward = false)) shouldBe empty
    TwoAndHalf.retreat("E3", diagonal.copy(backward = false)) shouldBe empty
    TwoAndHalf.retreat("E3", diagonal.copy(forward = false, backward = false)) shouldBe empty
  }
}
