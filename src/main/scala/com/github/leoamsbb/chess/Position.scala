package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.ChessBoard.withinBoard

import scala.language.implicitConversions

case class Position(row: Char, column: Int) {
  override def toString: String = s"$row$column"

  def increaseRow : Position = copy(row = (row.toInt + 1).toChar)
  def decreaseRow : Position = copy(row = (row.toInt - 1).toChar)

  def increaseColumn : Position = copy(column = column + 1)
  def decreaseColumn : Position = copy(column = column - 1)
}

object Position {
  implicit def fromString(strPosition: String) : Position = {
    val p = Position(
      strPosition.charAt(0),
      Integer.parseInt(strPosition.charAt(1).toString)
    )
    if (withinBoard(p))
      p
    else
      throw new Exception(
        """Invalid usage of Position.
          |Case Matters.
          |Limits: 'A' to 'H' and 1 to 8.
          |Example: D4
          |""".stripMargin)
  }
}

