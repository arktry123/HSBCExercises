package com.exercises.utils

import com.exercises.model.{Employee, External}

trait Utils[Customer] {

  def extractInstanceType(c: Customer) = {
    val instanceType: String = c match {
      case e: Employee => "Employee"
      case e: External => "External Customer"
    }
    instanceType
  }

  def getName(c: Customer) = {
    c match {
      case e: Employee => e.name
      case ex: External => ex.name
    }
  }
}
