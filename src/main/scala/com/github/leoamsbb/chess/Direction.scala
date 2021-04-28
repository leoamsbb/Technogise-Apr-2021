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

case class Vertical(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction

case class Horizontal(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction

case class Diagonal(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction
