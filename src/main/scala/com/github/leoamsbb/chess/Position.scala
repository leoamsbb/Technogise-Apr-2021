package com.github.leoamsbb.chess

case class Position(row: Char, col: Int) {
  override def toString: String = s"$row$col"
}

object Position {
  implicit def fromString(strPosition: String) : Position =
    Position(
      strPosition.charAt(0),
      Integer.parseInt(strPosition.charAt(1).toString)
    )
}

