package com.github.leoamsbb.chess

trait Step {
  def advance(current: Position, direction: Direction): List[Position]

  def retreat(current: Position, direction: Direction): List[Position]
}
