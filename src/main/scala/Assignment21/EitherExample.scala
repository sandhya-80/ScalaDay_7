package Assignment21

object EitherExample{

  // Function to parse a number from a string
  def parseNumber(input: String): Either[String, Int] =
    try {
      Right(input.toInt)
    } catch {
      case _: NumberFormatException => Left(s"Invalid number format: $input")
    }

  // Function to validate age
  def validateAge(age: Int): Either[String, Int] =
    if (age >= 18) Right(age)
    else Left("Age must be 18 or older")

  // Function to register a user with error handling
  def registerUser(input: String): Either[String, String] =
    for {
      age <- parseNumber(input)
      validAge <- validateAge(age)
    } yield s"User registered with age: $validAge"


  def main(args: Array[String]): Unit = {
    val testInputs = List("25", "abc", "16", "30")

    testInputs.foreach { input =>
      registerUser(input) match {
        case Right(success) => println(s"Success: $success")
        case Left(error)    => println(s"Error: $error")
      }
    }
  }
}
