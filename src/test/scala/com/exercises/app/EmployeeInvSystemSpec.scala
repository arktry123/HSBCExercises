package com.exercises.app

import com.exercises.model.Employee
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeInvSystemSpec extends AnyFlatSpec {

  it should "successfully create and get an employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val employee1 = Employee("Employee 1")

    empInvSystem.create(employee1)
    assert(empInvSystem.get(employee1).nonEmpty)
    assert(empInvSystem.get(employee1).get === employee1)
  }

  it should "successfully return empty for non existing employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val employee1 = Employee("Employee 1")
    val employee2 = Employee("Employee 2")

    empInvSystem.create(employee1)
    assert(empInvSystem.get(employee2).isEmpty)
  }

  it should "successfully delete an existing employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val employee1 = Employee("Employee 1")

    empInvSystem.create(employee1)
    empInvSystem.delete(employee1)
    assert(empInvSystem.get(employee1).isEmpty)
  }

  it should "successfully delete non existing employee" in {
    val empInvSystem = new CustomerInvSystem[Employee]
    val employee2 = Employee("Employee 2")

    empInvSystem.delete(employee2)
    assert(empInvSystem.get(employee2).isEmpty)
  }
}
