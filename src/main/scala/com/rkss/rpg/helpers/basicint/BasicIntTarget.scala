package com.rkss.rpg.helpers.basicint

sealed trait BasicIntTarget

case object BasicIntTargetValue extends BasicIntTarget
case object BasicIntTargetMaximum extends BasicIntTarget
case object BasicIntTargetMinimum extends BasicIntTarget
