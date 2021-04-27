package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.ChessBoard.outsideBoard

import scala.annotation.tailrec

case object Default extends Step {
  def advance(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(true, _) =>
      val fromRow = current.increaseRow.row
      (fromRow to 'H').map(Position(_, current.column)).toList
    case Horizontal(true, _) =>
      val fromColumn = current.increaseColumn.column
      (fromColumn to 8).map(Position(current.row, _)).toList
    case Diagonal(true, _) =>
      val left = (_:Position).increaseRow.decreaseColumn
      val right = (_:Position).increaseRow.increaseColumn
      loop(current, Nil)(left) ::: loop(current, Nil)(right)
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
      val left = (_:Position).decreaseRow.decreaseColumn
      val right = (_:Position).decreaseRow.increaseColumn
      loop(current, Nil)(left) ::: loop(current, Nil)(right)
    case _ => Nil
  }

  @tailrec
  def loop(current: Position, acc: List[Position])(mapper: Position => Position): List[Position] = {
    val next = mapper(current)
    if (outsideBoard(next))
      acc
    else
      loop(next, next :: acc)(mapper)
  }
}
