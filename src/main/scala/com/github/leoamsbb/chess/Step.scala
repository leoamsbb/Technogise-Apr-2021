package com.github.leoamsbb.chess

sealed trait Step {
  def advance(current: Position, direction: Direction): List[Position] = Nil

  def retreat(current: Position, direction: Direction): List[Position] = Nil
}

case object Default extends Step

case object Single extends Step {
  override def advance(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(true, _) => List(current.increaseRow)
    case Horizontal(true, _) => List(current.increaseColumn)
    case Diagonal(true, _) => List(
      current.increaseRow.increaseColumn,
      current.increaseRow.decreaseColumn
    )
    case _ => Nil
  }

  override def retreat(current: Position, direction: Direction): List[Position] = direction match {
    case Vertical(_, true) => List(current.decreaseRow)
    case Horizontal(_, true) => List(current.decreaseColumn)
    case Diagonal(_, true) => List(
      current.decreaseRow.increaseColumn,
      current.decreaseRow.decreaseColumn
    )
    case _ => Nil
  }
}

case object TwoAndHalf extends Step
