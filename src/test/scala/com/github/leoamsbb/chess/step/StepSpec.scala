package com.github.leoamsbb.chess.step

import com.github.leoamsbb.chess.{ChessSpec, Diagonal, Horizontal, Vertical}

class StepSpec extends ChessSpec {
  protected val vertical: Vertical = Vertical()
  protected val horizontal: Horizontal = Horizontal()
  protected val diagonal: Diagonal = Diagonal()
}
