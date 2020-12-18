package com.exercises.model

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse
import org.scalatest.flatspec.AnyFlatSpec

class PersonSpec extends AnyFlatSpec {
  it should "create person object with correct name and age" in {
    implicit val formats = DefaultFormats
    val json = """ {"name":"Tom", "age": 38} """
    val p = parse(json).extract[Person]
    assert(p.name == "Tom")
    assert(p.age == 38)
  }

  it should "be able to create a Person with default age" in {
    implicit val formats = DefaultFormats
    val json = """ {"name":"Tom1"} """
    val p = parse(json).extract[Person]
    assert(p.name == "Tom1")
    assert(p.age == 0)
  }

  it should "be able to create a PersonExt with location and default age" in {
    implicit val formats = DefaultFormats
    val json = """ {"name":"Tom1", "location":"London"} """
    val p = parse(json).extract[PersonExt]
    assert(p.name == "Tom1")
    assert(p.age == 0)
    assert(p.getLocation == "London")
  }

  it should "be able to create a PersonExt with default location" in {
    implicit val formats = DefaultFormats
    val json = """ {"name":"Tom1"} """
    val p = parse(json).extract[PersonExt]
    assert(p.name == "Tom1")
    assert(p.age == 0)
    assert(p.getLocation.isEmpty)
  }
}
