package com.github.leoamsbb.chess

sealed trait ChessPiece {
  def current: Position
}

case class King(current: Position) extends ChessPiece
case class Horse(current: Position) extends ChessPiece
case class Queen(current: Position) extends ChessPiece
case class Bishop(current: Position) extends ChessPiece
case class Rook(current: Position) extends ChessPiece
case class Pawn(current: Position) extends ChessPiece

object ChessPiece {
  implicit def fromString(input: String): ChessPiece = input match {
    case s"King $pos" => King(pos)
    case s"Horse $pos" => Horse(pos)
    case s"Queen $pos" => Queen(pos)
    case s"Bishop $pos" => Bishop(pos)
    case s"Rook $pos" => Rook(pos)
    case s"Pawn $pos" => Pawn(pos)
  }
}

