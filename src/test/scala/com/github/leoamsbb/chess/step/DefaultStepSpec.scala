package com.github.leoamsbb.chess.step

class DefaultStepSpec extends StepSpec {
  it("should return correct position when taken in vertical forward direction") {
    verifyOutput(Default.advance("F3", vertical), List("G3", "H3"))
  }
  it("should return correct position when taken in vertical backward direction") {
    verifyOutput(Default.retreat("F3", vertical), List("A3", "B3", "C3", "D3", "E3"))
  }
  it("should return empty list when forward or backward is disabled for vertical direction") {
    Default.advance("D5", vertical.copy(forward = false)) shouldBe empty
    Default.advance("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
    Default.retreat("D5", vertical.copy(backward = false)) shouldBe empty
    Default.retreat("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return correct position when taken in horizontal forward direction") {
    verifyOutput(Default.advance("F3", horizontal), List("F4", "F5", "F6", "F7", "F8"))
  }
  it("should return correct position when taken in horizontal backward direction") {
    verifyOutput(Default.retreat("F3", horizontal), List("F1", "F2"))
  }
  it("should return empty list when forward or backward is disabled for horizontal direction") {
    Default.advance("D5", horizontal.copy(forward = false)) shouldBe empty
    Default.advance("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
    Default.retreat("D5", horizontal.copy(backward = false)) shouldBe empty
    Default.retreat("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return correct position when taken in diagonal forward direction") {
    verifyOutput(Default.advance("F3", diagonal), List("H1", "G2", "G4", "H5"))
  }
  it("should return correct position when taken in diagonal backward direction") {
    verifyOutput(Default.retreat("F3", diagonal), List("D1", "E2", "E4", "D5", "C6", "B7", "A8"))
  }
  it("should return empty list when forward or backward is disabled for diagonal direction") {
    Default.advance("D5", diagonal.copy(forward = false)) shouldBe empty
    Default.advance("D5", diagonal.copy(forward = false, backward = false)) shouldBe empty
    Default.retreat("D5", diagonal.copy(backward = false)) shouldBe empty
    Default.retreat("D5", diagonal.copy(forward = false, backward = false)) shouldBe empty
  }
}
