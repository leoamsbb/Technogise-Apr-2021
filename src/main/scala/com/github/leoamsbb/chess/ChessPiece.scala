package com.github.leoamsbb.chess

sealed trait ChessPiece {
  def current: Position

  def step: Step = Default

  def canMove: List[Direction] = List(Vertical(), Horizontal(), Diagonal())

}

case class King(current: Position) extends ChessPiece {
  override val step:Step = Single
}

case class Horse(current: Position) extends ChessPiece {
  override val step: Step = TwoAndHalf

  override def canMove: List[Direction] = List(Vertical(), Horizontal())
}

case class Queen(current: Position) extends ChessPiece

case class Bishop(current: Position) extends ChessPiece {
  override def canMove: List[Direction] = List(Diagonal())
}

case class Rook(current: Position) extends ChessPiece {
  override def canMove: List[Direction] = List(Vertical(), Horizontal())
}

case class Pawn(current: Position) extends ChessPiece {
  override val step:Step = Single
}

object ChessPiece {
  implicit def fromString(input: String): ChessPiece = input match {
    case s"King $pos" => King(pos)
    case s"Horse $pos" => Horse(pos)
    case s"Queen $pos" => Queen(pos)
    case s"Bishop $pos" => Bishop(pos)
    case s"Rook $pos" => Rook(pos)
    case s"Pawn $pos" => Pawn(pos)
    case _ => throw new Exception("Invalid input. Case matters. Usage: King D5")
  }
}

