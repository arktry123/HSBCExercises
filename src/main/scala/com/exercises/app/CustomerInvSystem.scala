package com.exercises.app

import com.exercises.model.Customer

class CustomerInvSystem[+A <: Customer] extends CustomerListing[Customer] with CustomerStorageService[Customer] {
  override def create(c: Customer): Unit = createInStorage(c)

  override def get(c: Customer): Option[Customer] = getFromStorage(c)

  override def update(c: Customer): Unit = updateInStorage(c)

  override def delete(c: Customer): Unit = deleteInStorage(c)
}
