package com.github.leoamsbb.chess.step

class SingleStepSpec extends StepSpec {

  it("should return correct position when taken in vertical forward direction") {
    verifyOutput(Single.advance("D5", vertical), List("E5"))
  }
  it("should return correct position when taken in vertical backward direction") {
    verifyOutput(Single.retreat("D5", vertical), List("C5"))
  }
  it("should return empty list when forward or backward is disabled for vertical direction") {
    Single.advance("D5", vertical.copy(forward = false)) shouldBe empty
    Single.advance("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
    Single.retreat("D5", vertical.copy(backward = false)) shouldBe empty
    Single.retreat("D5", vertical.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return correct position when taken in horizontal forward direction") {
    verifyOutput(Single.advance("D5", horizontal), List("D6"))
  }
  it("should return correct position when taken in horizontal backward direction") {
    verifyOutput(Single.retreat("D5", horizontal), List("D4"))
  }
  it("should return empty list when forward or backward is disabled for horizontal direction") {
    Single.advance("D5", horizontal.copy(forward = false)) shouldBe empty
    Single.advance("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
    Single.retreat("D5", horizontal.copy(backward = false)) shouldBe empty
    Single.retreat("D5", horizontal.copy(forward = false, backward = false)) shouldBe empty
  }

  it("should return correct position when taken in diagonal forward direction") {
    verifyOutput(Single.advance("D5", diagonal), List("E4", "E6"))
  }
  it("should return correct position when taken in diagonal backward direction") {
    verifyOutput(Single.retreat("D5", diagonal), List("C4", "C6"))
  }
  it("should return empty list when forward or backward is disabled for diagonal direction") {
    Single.advance("D5", diagonal.copy(forward = false)) shouldBe empty
    Single.advance("D5", diagonal.copy(forward = false, backward = false)) shouldBe empty
    Single.retreat("D5", diagonal.copy(backward = false)) shouldBe empty
    Single.retreat("D5", diagonal.copy(forward = false, backward = false)) shouldBe empty
  }
}
