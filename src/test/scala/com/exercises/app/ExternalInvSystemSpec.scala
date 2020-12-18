package com.exercises.app

import com.exercises.model.External
import org.scalatest.flatspec.AnyFlatSpec

class ExternalInvSystemSpec extends AnyFlatSpec {
  it should "successfully create and get an External" in {
    val extInvSystem = new CustomerInvSystem[External]
    val external1 = External("External 1")

    extInvSystem.create(external1)
    assert(extInvSystem.get(external1).nonEmpty)
    assert(extInvSystem.get(external1).get === external1)
  }

  it should "successfully return empty for non existing External" in {
    val extInvSystem = new CustomerInvSystem[External]
    val external1 = External("External 1")
    val external2 = External("External 2")

    extInvSystem.create(external1)
    assert(extInvSystem.get(external2).isEmpty)
  }

  it should "successfully delete an existing External" in {
    val extInvSystem = new CustomerInvSystem[External]
    val external1 = External("External 1")

    extInvSystem.create(external1)
    extInvSystem.delete(external1)
    assert(extInvSystem.get(external1).isEmpty)
  }

  it should "successfully delete non existing External" in {
    val extInvSystem = new CustomerInvSystem[External]
    val external2 = External("External 2")

    extInvSystem.delete(external2)
    assert(extInvSystem.get(external2).isEmpty)
  }
}
