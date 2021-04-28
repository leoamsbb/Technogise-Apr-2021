package com.github.leoamsbb.chess

object ChessBoard {
  def withinBoard(input: Position): Boolean =
    input.row <= 'H' &&
      input.row >= 'A' &&
      input.column <= 8 &&
      input.column >= 1

  def outsideBoard(input: Position): Boolean = !withinBoard(input)

}
