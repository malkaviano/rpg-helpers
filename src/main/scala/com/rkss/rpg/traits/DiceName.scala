package com.rkss.rpg.traits

sealed trait DiceName

case object FourSidedDiceName extends DiceName {
  override def toString: String = "D4"
}

case object SixSidedDiceName extends DiceName {
  override def toString: String = "D6"
}

case object EightSidedDiceName extends DiceName {
  override def toString: String = "D8"
}

case object TenSidedDiceName extends DiceName {
  override def toString: String = "D10"
}

case object HundredSidedDiceName extends DiceName {
  override def toString: String = "D100"
}