package com.exercises.app

import com.exercises.model.{Customer, Employee, External}
import org.scalatest.flatspec.AnyFlatSpec

class CustomerSystemSpec extends AnyFlatSpec {
  it should "return true in case of an existing employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val customerSystem = new CustomerSystem[Employee]
    customerSystem.setCustomerInvSystem(empInvSystem)

    val employee1 = Employee("Employee 1")
    empInvSystem.create(employee1)
    assert(customerSystem.checkCustomerExists(employee1) === true)
  }

  it should "return false in case of non-existing employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val customerSystem = new CustomerSystem[Employee]
    customerSystem.setCustomerInvSystem(empInvSystem)

    val employee1 = Employee("Employee 1")
    assert(customerSystem.checkCustomerExists(employee1) === false)
  }

  it should "return true in case of an existing external" in {
    val extInvSystem = new CustomerInvSystem[External]
    val customerSystem = new CustomerSystem[External]
    customerSystem.setCustomerInvSystem(extInvSystem)

    val external1 = External("Employee 1")
    extInvSystem.create(external1)
    assert(customerSystem.checkCustomerExists(external1) === true)
  }

  it should "return false in case of non-existing external" in {
    val extInvSystem = new CustomerInvSystem[External]
    val customerSystem = new CustomerSystem[External]
    customerSystem.setCustomerInvSystem(extInvSystem)

    val external1 = External("Employee 1")
    assert(customerSystem.checkCustomerExists(external1) === false)
  }
}
