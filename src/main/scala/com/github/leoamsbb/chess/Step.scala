package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.ChessBoard.outsideBoard

import scala.annotation.tailrec

sealed trait Step {
  def advance(current: Position, direction: Direction): List[Position]

  def retreat(current: Position, direction: Direction): List[Position]
}

case object Default extends Step {
  def advance(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(true, _) =>
      val fromRow = current.increaseRow.row
      (fromRow to 'H').map(Position(_, current.column)).toList
    case Horizontal(true, _) =>
      val fromColumn = current.increaseColumn.column
      (fromColumn to 8).map(Position(current.row, _)).toList
    case Diagonal(true, _) =>
      leftForward(current, Nil) ::: rightForward(current, Nil)
    case _ => Nil
  }

  def retreat(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(_, true) =>
      val toRow = current.row
      ('A' until toRow).map(Position(_, current.column)).toList
    case Horizontal(_, true) =>
      val toColumn = current.column
      (1 until toColumn).map(Position(current.row, _)).toList
    case Diagonal(_, true) =>
      leftBackward(current, Nil) ::: rightBackward(current, Nil)
    case _ => Nil
  }

  @tailrec
  def leftForward(current: Position, acc: List[Position]): List[Position] =
    if(outsideBoard(current.increaseRow.decreaseColumn))
      acc
    else
      leftForward(current.increaseRow.decreaseColumn, current.increaseRow.decreaseColumn :: acc)

  @tailrec
  def rightForward(current: Position, acc: List[Position]): List[Position] =
    if(outsideBoard(current.increaseRow.increaseColumn))
      acc
    else
      rightForward(current.increaseRow.increaseColumn, current.increaseRow.increaseColumn :: acc)

  @tailrec
  def leftBackward(current: Position, acc: List[Position]): List[Position] =
    if(outsideBoard(current.decreaseRow.decreaseColumn))
      acc
    else
      leftBackward(current.decreaseRow.decreaseColumn, current.decreaseRow.decreaseColumn :: acc)

  @tailrec
  def rightBackward(current: Position, acc: List[Position]): List[Position] =
    if(outsideBoard(current.increaseRow.increaseColumn))
      acc
    else
      rightBackward(current.decreaseRow.increaseColumn, current.decreaseRow.increaseColumn :: acc)
}

case object Single extends Step {
  def advance(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(true, _) => List(current.increaseRow)
    case Horizontal(true, _) => List(current.increaseColumn)
    case Diagonal(true, _) => List(
      current.increaseRow.increaseColumn,
      current.increaseRow.decreaseColumn
    )
    case _ => Nil
  }

  def retreat(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(_, true) => List(current.decreaseRow)
    case Horizontal(_, true) => List(current.decreaseColumn)
    case Diagonal(_, true) => List(
      current.decreaseRow.increaseColumn,
      current.decreaseRow.decreaseColumn
    )
    case _ => Nil
  }
}

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
