import org.scalatest.funsuite.AnyFunSuite
import scala.util.{Try, Success, Failure}

class TryExamplesTest extends AnyFunSuite {

  test("safeDivide should return Success for valid division and Failure for division by zero") {
    assert(TryExamples.safeDivide(10, 2) == Success(5))
    assert(TryExamples.safeDivide(10, 0).isFailure)
  }

  test("doubleResult should return Success with the doubled value") {
    assert(TryExamples.doubleResult(5) == Success(10))  // Pass plain Int instead of Success(5)
  }

  test("divideAndDouble should return Success with the doubled quotient or Failure on error") {
    assert(TryExamples.divideAndDouble(10, 2) == Success(10))
    assert(TryExamples.divideAndDouble(10, 0).isFailure)
  }

  test("safeDivideWithFallback should return a fallback value on failure") {
    assert(TryExamples.safeDivideWithFallback(10, 0) == Success(-1))
  }

  test("safeDivideWithAnotherFallback should return another fallback value on failure") {
    assert(TryExamples.safeDivideWithAnotherFallback(10, 0) == Success(0))
  }
}
