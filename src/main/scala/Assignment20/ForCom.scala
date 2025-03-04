package Assignment20

object ForCom {
  def processOptionalValues(opt1: Option[Int], opt2: Option[Int]): Option[Int] =
    for {
      a <- opt1
      b <- opt2
    } yield a + b


  def main(args: Array[String]): Unit = {
      println(s"Process: Some(5) and Some(10): ${processOptionalValues(Some(5), Some(10))}")
      println(s"Process: Some(5) and None: ${processOptionalValues(Some(5), None)}")
    }
}
