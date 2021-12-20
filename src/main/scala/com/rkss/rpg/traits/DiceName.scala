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

case object TwelveSidedDiceName extends DiceName {
  override def toString: String = "D12"
}

case object TwentySidedDiceName extends DiceName {
  override def toString: String = "D20"
}

case object HundredSidedDiceName extends DiceName {
  override def toString: String = "D100"
}

case object ThreeSidedDiceName extends DiceName {
  override def toString: String = "D3"
}

case object TwoSidedDiceName extends DiceName {
  override def toString: String = "D2"
}
