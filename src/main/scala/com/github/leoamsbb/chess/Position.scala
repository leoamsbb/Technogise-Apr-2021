package com.github.leoamsbb.chess

import scala.language.implicitConversions

case class Position(row: Char, column: Int) {
  override def toString: String = s"$row$column"

  def increaseRow : Position = copy(row = (row.toInt + 1).toChar)
  def decreaseRow : Position = copy(row = (row.toInt - 1).toChar)

  def increaseColumn : Position = copy(column = column + 1)
  def decreaseColumn : Position = copy(column = column - 1)
}

object Position {
  implicit def fromString(strPosition: String) : Position =
    Position(
      strPosition.charAt(0),
      Integer.parseInt(strPosition.charAt(1).toString)
    )
}

