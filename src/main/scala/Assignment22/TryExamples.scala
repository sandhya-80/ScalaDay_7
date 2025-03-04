import scala.util.{Try, Success, Failure}

object TryExamples {

  // Wrap a computation that might throw an exception
  def safeDivide(a: Int, b: Int): Try[Int] = Try(a / b)

  // Corrected: doubleResult should take Int, not Try[Int]
  def doubleResult(value: Int): Try[Int] = Success(value * 2)

  // Chaining Try computations using flatMap
  def divideAndDouble(a: Int, b: Int): Try[Int] =
    safeDivide(a, b).flatMap(doubleResult)

  // Error recovery using recover
  def safeDivideWithFallback(a: Int, b: Int): Try[Int] =
    safeDivide(a, b).recover {
      case _: ArithmeticException => -1 // Return -1 in case of division by zero
    }

  // Error recovery using recoverWith
  def safeDivideWithAnotherFallback(a: Int, b: Int): Try[Int] =
    safeDivide(a, b).recoverWith {
      case _: ArithmeticException => Success(0) // Provide a safe fallback value
    }

  def main(args: Array[String]): Unit = {
    val result1 = safeDivide(10, 2)
    println(s"Safe divide (10/2): $result1") 

    val result2 = safeDivide(10, 0)
    println(s"Safe divide (10/0): $result2") 

    val doubled = result1.flatMap(doubleResult)
    println(s"Doubled result: $doubled") 

    val chained = divideAndDouble(10, 2)
    println(s"Divide and double: $chained") 

    val recovered = safeDivideWithFallback(10, 0)
    println(s"Recovered division (10/0): $recovered") 

    val recoveredWithAnotherFallback = safeDivideWithAnotherFallback(10, 0)
    println(s"Recovered with another fallback: $recoveredWithAnotherFallback") 
  }
}
