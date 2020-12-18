package com.exercises.model

class PersonExt(override val name: String, override val age: Int = 0, location: String = "") extends Person(name, age) {
  println(s"Location: $location")

  def getLocation = location
}
