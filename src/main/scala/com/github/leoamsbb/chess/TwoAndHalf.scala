package com.github.leoamsbb.chess

case object TwoAndHalf extends Step {
  private val verticalHalfSteps = List((_: Position).increaseColumn, (_: Position).decreaseColumn)
  private val horizontalHalfSteps = List((_: Position).increaseRow, (_: Position).decreaseRow)

  def advance(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(true, _) =>
      val twoSteps = (_: Position).increaseRow.increaseRow
      verticalHalfSteps.map(twoSteps andThen _).map(_ (current))
    case Horizontal(true, _) =>
      val twoSteps = (_: Position).increaseColumn.increaseColumn
      horizontalHalfSteps.map(twoSteps andThen _).map(_ (current))
    case _ => Nil
  }

  def retreat(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(_, true) =>
      val twoSteps = (_: Position).decreaseRow.decreaseRow
      verticalHalfSteps.map(twoSteps andThen _).map(_ (current))
    case Horizontal(_, true) =>
      val twoSteps = (_: Position).decreaseColumn.decreaseColumn
      horizontalHalfSteps.map(twoSteps andThen _).map(_ (current))
    case _ => Nil
  }
}
