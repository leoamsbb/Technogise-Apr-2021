package com.github.leoamsbb.chess

import scala.language.implicitConversions

case class Position(row: Char, column: Int) {
  override def toString: String = s"$row$column"
}

object Position {
  implicit def fromString(strPosition: String) : Position =
    Position(
      strPosition.charAt(0),
      Integer.parseInt(strPosition.charAt(1).toString)
    )
}

