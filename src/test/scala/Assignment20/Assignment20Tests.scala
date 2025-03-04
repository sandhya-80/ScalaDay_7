import org.scalatest.funsuite.AnyFunSuite
import Assignment20.{ForCom, OptionsExample, TransformOption}

class Assignment20Tests extends AnyFunSuite {

  test("processOptionalValues should return Some(sum) if both options are Some") {
    assert(ForCom.processOptionalValues(Some(5), Some(10)) == Some(15))
  }

  test("processOptionalValues should return None if any option is None") {
    assert(ForCom.processOptionalValues(Some(5), None) == None)
    assert(ForCom.processOptionalValues(None, Some(10)) == None)
    assert(ForCom.processOptionalValues(None, None) == None)
  }

  test("getElement should return Some(value) if index is valid") {
    val list = List(10, 20, 30)
    assert(OptionsExample.getElement(list, 1) == Some(20))
    assert(OptionsExample.getElement(list, 2) == Some(30))
  }

  test("getElement should return None if index is out of bounds") {
    val list = List(10, 20, 30)
    assert(OptionsExample.getElement(list, 5) == None)
    assert(OptionsExample.getElement(list, -1) == None)
  }

  test("transformOption should double the value inside Some") {
    assert(TransformOption.transformOption(Some(5)) === Some(10))
    assert(TransformOption.transformOption(Some(0)) === Some(0))
  }

  test("transformOption should return None if input is None") {
    assert(TransformOption.transformOption(None) == None)
  }

  test("flatTransformOption should halve the value if greater than 10") {
    assert(TransformOption.flatTransformOption(Some(20)) == Some(10))
    assert(TransformOption.flatTransformOption(Some(12)) == Some(6))
  }

  test("flatTransformOption should return None if value is 10 or less") {
    assert(TransformOption.flatTransformOption(Some(10)) == None)
    assert(TransformOption.flatTransformOption(Some(5)) == None)
    assert(TransformOption.flatTransformOption(None) == None)
  }
}
