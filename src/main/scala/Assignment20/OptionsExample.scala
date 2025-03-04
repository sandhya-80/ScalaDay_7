package Assignment20

object OptionsExample
{
  def getElement[T](list: List[T], index: Int): Option[T] =
    if (index >= 0 && index < list.length) Some(list(index)) else None

  def main(args: Array[String]): Unit = {
    val numbers = List(10, 20, 30)

    println(getElement(numbers, 1))
    println(getElement(numbers, 5))
    println(getElement(numbers, 2).get)
    println(getElement(numbers, 3).get) //exception--no such element (None case)
  }
}
