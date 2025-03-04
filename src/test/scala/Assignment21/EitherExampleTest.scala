import org.scalatest.funsuite.AnyFunSuite
import Assignment21.EitherExample._

class EitherExampleTest extends AnyFunSuite {

  test("parseNumber should return Right for valid numbers and Left for invalid input") {
    assert(parseNumber("25") == Right(25))
    assert(parseNumber("abc").isLeft)
  }

  test("validateAge should return Right for age >= 18 and Left for age < 18") {
    assert(validateAge(20) == Right(20))
    assert(validateAge(17) == Left("Age must be 18 or older"))
  }

  test("registerUser should correctly chain Either operations") {
    assert(registerUser("25") == Right("User registered with age: 25"))
    assert(registerUser("16") == Left("Age must be 18 or older"))
    assert(registerUser("xyz").isLeft)
  }
}
