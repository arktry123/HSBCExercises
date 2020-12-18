package com.exercises.app

import com.exercises.utils.Utils

trait CustomerStorageService[Customer] extends Utils[Customer] {
  //the storage is an in-memory List.
  var tempStorage: Map[Customer, Customer] = Map.empty

  protected def createInStorage(c: Customer) = {
    val instanceType: String = extractInstanceType(c)
    val name = getName(c)
    println(s"creating an $instanceType $name")
    tempStorage = tempStorage + (c -> c)
    tempStorage
  }

  protected def getFromStorage(c: Customer): Option[Customer] = {
    val instanceType: String = extractInstanceType(c)
    val name = getName(c)
    println(s"getting the $instanceType $name")
    tempStorage.get(c)
  }

  protected def updateInStorage(c: Customer): Unit = {
    val instanceType: String = extractInstanceType(c)
    val name = getName(c)
    println(s"updating a $instanceType $name")
    tempStorage = tempStorage + (c -> c)
  }

  protected def deleteInStorage(c: Customer): Unit = {
    val instanceType: String = extractInstanceType(c)
    val name = getName(c)
    println(s"deleting a $instanceType $name")
    tempStorage = tempStorage - c
  }

}
