package com.github.leoamsbb.chess

sealed trait Direction {
  def forward: Boolean

  def backward: Boolean
}

case class Vertical(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction

case class Horizontal(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction

case class Diagonal(override val forward: Boolean = true, override val backward: Boolean = true) extends Direction
