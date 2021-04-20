package com.github.leoamsbb.chess

import org.scalatest.{FunSpec, Matchers}

class StepSpec extends FunSpec with Matchers {

  val vertical = Vertical()
  val horizontal = Horizontal()
  val diagonal = Diagonal()

  describe("Single Step") {
    it("should return correct position when taken in vertical forward direction") {
      val actual = Single.advance("D5", vertical).map(_.toString)
      actual should contain theSameElementsAs List("E5")
    }
    it("should return correct position when taken in vertical backward direction") {
      val actual = Single.retreat("D5", vertical).map(_.toString)
      actual should contain theSameElementsAs List("C5")
    }

    it("should return correct position when taken in horizontal forward direction") {
      val actual = Single.advance("D5", horizontal).map(_.toString)
      actual should contain theSameElementsAs List("D6")
    }
    it("should return correct position when taken in horizontal backward direction") {
      val actual = Single.retreat("D5", horizontal).map(_.toString)
      actual should contain theSameElementsAs List("D4")
    }

    it("should return correct position when taken in diagonal forward direction") {
      val actual = Single.advance("D5", diagonal).map(_.toString)
      actual should contain theSameElementsAs List("E4", "E6")
    }
    it("should return correct position when taken in diagonal backward direction") {
      val actual = Single.retreat("D5", diagonal).map(_.toString)
      actual should contain theSameElementsAs List("C4", "C6")
    }
  }
}
