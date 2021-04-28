package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.ChessBoard.withinBoard
import com.github.leoamsbb.chess.ChessPiece.{diagonal, horizontal, vertical}
import com.github.leoamsbb.chess.step.{Default, Single, Step, TwoAndHalf}

import scala.language.implicitConversions

sealed trait ChessPiece {
  def current: Position

  def step: Step

  def possibleDirections: List[Direction]

  def possiblePositions: List[Position] = possibleDirections
    .flatMap { dir => dir.possibleMoves(step, current) }
    .filter(withinBoard)
}

case class King(current: Position) extends ChessPiece {
  val step: Step = Single

  val possibleDirections: List[Direction] = List(vertical, horizontal, diagonal)
}

case class Horse(current: Position) extends ChessPiece {
  val step: Step = TwoAndHalf

  override def possibleDirections: List[Direction] = List(vertical, horizontal)
}

case class Queen(current: Position) extends ChessPiece {
  val step: Step = Default

  val possibleDirections: List[Direction] = List(vertical, horizontal, diagonal)
}

case class Bishop(current: Position) extends ChessPiece {
  val step: Step = Default

  val possibleDirections: List[Direction] = List(diagonal)
}

case class Rook(current: Position) extends ChessPiece {
  val step: Step = Default

  val possibleDirections: List[Direction] = List(vertical, horizontal)
}

case class Pawn(current: Position) extends ChessPiece {
  override val step: Step = Single

  val possibleDirections: List[Direction] = List(vertical.copy(backward = false))
}

object ChessPiece {
  implicit def fromString(input: String): ChessPiece = input match {
    case s"King $pos" => King(pos)
    case s"Horse $pos" => Horse(pos)
    case s"Queen $pos" => Queen(pos)
    case s"Bishop $pos" => Bishop(pos)
    case s"Rook $pos" => Rook(pos)
    case s"Pawn $pos" => Pawn(pos)
    case _ => throw new Exception("Invalid input of Chess Piece Name. Case matters. Usage: King D5")
  }

  val vertical: Vertical = Vertical()
  val horizontal: Horizontal = Horizontal()
  val diagonal: Diagonal = Diagonal()
}

