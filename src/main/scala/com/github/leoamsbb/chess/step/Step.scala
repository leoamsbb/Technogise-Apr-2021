package com.github.leoamsbb.chess.step

import com.github.leoamsbb.chess.{Direction, Position}

trait Step {
  def advance(current: Position, direction: Direction): List[Position]

  def retreat(current: Position, direction: Direction): List[Position]
}
