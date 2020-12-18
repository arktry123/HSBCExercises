package com.exercises.app

trait CustomerListing[Customer] {

  def create(c: Customer)

  def get(c: Customer): Option[Customer]

  def update(c: Customer)

  def delete(c: Customer)
}
