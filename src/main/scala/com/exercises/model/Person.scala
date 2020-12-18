package com.exercises.model

case class Person(name: String, age: Int = 0) {
  println(s"Name: $name")
  println(s"age: $age")
}
