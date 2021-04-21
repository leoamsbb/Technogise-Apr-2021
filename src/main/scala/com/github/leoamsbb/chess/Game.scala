package com.github.leoamsbb.chess

import scala.io.StdIn.readLine

object Game extends App {
  println(ChessPiece.fromString(readLine()).possibleMoves)
}
