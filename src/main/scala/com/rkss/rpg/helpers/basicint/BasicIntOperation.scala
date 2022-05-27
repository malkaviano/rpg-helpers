package com.rkss.rpg.helpers.basicint

sealed trait BasicIntOperation

case object BasicIntOperationPlus extends BasicIntOperation
case object BasicIntOperationMinus extends BasicIntOperation
case object BasicIntOperationMultiply extends BasicIntOperation
case object BasicIntOperationDiv extends BasicIntOperation