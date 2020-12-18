package com.exercises

import com.exercises.app.{CustomerInvSystem, CustomerSystem}
import com.exercises.model.{Customer, Employee, External, Person, PersonExt}
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse

object SolutionsApp extends App {
  //First Exercise
  def printBaseNumbers(start: Int, end: Int) = {
    Range(start, end).filter(_ % 2 != 0).foreach(println)
  }

  println("**************** question 1 ****************")
  printBaseNumbers(100, 200)

  //Second Exercise
  println("**************** question 2 ****************")
  val empInvSystem = new CustomerInvSystem[Employee]
  val employee1 = Employee("Employee 1")
  val employee2 = Employee("Employee 2")

  empInvSystem.create(employee1)
  empInvSystem.update(employee1)
  empInvSystem.get(employee2)

  val extInvSystem = new CustomerInvSystem[External]
  val extCustomer1 = External("External Customer 1")
  val extCustomer2 = External("External Customer 2")

  extInvSystem.update(extCustomer1)
  extInvSystem.create(extCustomer1)
  extInvSystem.delete(extCustomer2)

  println("**************** question 3 ****************")

  val customerSystem = new CustomerSystem[Customer]
  customerSystem.setCustomerInvSystem(empInvSystem)
  customerSystem.checkCustomerExists(employee1)

  val extrenalSystem = new CustomerSystem[External]
  extrenalSystem.setCustomerInvSystem(extInvSystem)
  extrenalSystem.checkCustomerExists(extCustomer1)

  println("**************** question 4 ****************")

  implicit val formats = DefaultFormats

  val json = """ {"name":"Tom", "age": 38} """
  parse(json).extract[Person]

  val json1 = """ {"name":"Tom1", "location":"London", "age": 38} """
  parse(json1).extract[PersonExt]
}
