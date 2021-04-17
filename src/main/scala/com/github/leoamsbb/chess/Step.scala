package com.github.leoamsbb.chess

sealed trait Step

case object Default extends Step // Can move across but single step

case object Single extends Step

case object TwoAndHalf extends Step
