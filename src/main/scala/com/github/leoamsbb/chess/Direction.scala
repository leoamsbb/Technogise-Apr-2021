package com.github.leoamsbb.chess

import com.github.leoamsbb.chess.step.Step

sealed trait Direction {
  def forward: Boolean

  def backward: Boolean

  def possibleMoves(step: Step, current: Position): List[Position] = List(
    step.advance(current, this),
    step.retreat(current, this)
  ).flatten
}

case class Vertical(forward: Boolean = true, backward: Boolean = true) extends Direction

case class Horizontal(forward: Boolean = true, backward: Boolean = true) extends Direction

case class Diagonal(forward: Boolean = true, backward: Boolean = true) extends Direction
