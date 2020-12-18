package com.exercises.app

import com.exercises.model.Customer
import com.exercises.utils.Utils

class CustomerSystem[C <: Customer] extends Utils[Customer] {

  var cInvSystem = new CustomerInvSystem[Customer]

  def checkCustomerExists(c: Customer): Boolean = {
    val instanceType = extractInstanceType(c)
    val name = getName(c)
    println(s"Checking Customer exists in our Database  = $instanceType($name)\n")
    cInvSystem.get(c).nonEmpty
  }

  def setCustomerInvSystem(cInvSystem1: CustomerInvSystem[Customer]) = {
    cInvSystem = cInvSystem1
  }
}
