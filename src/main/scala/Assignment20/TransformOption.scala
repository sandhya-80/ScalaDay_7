package Assignment20

object TransformOption
{
  def transformOption(opt: Option[Int]): Option[Int] =
    opt.map(_ * 2) // Double the value if it exists

  def flatTransformOption(opt: Option[Int]): Option[Int] =
    opt.flatMap(value => if (value > 10) Some(value / 2) else None)

  def main(args: Array[String]): Unit = {

    println(s"Transform Some(5): ${transformOption(Some(5))}")
    println(s"Transform None: ${transformOption(None)}")

    println(s"Flat transform Some(20): ${flatTransformOption(Some(20))}")
    println(s"Flat transform Some(5): ${flatTransformOption(Some(5))}")

    val listt = List(1,2,3,4,10)
    println(listt.map(_*2))

    val mymap =Map(1->"Sandhya", 2->"Ayu", 3->"Subh")
    println(mymap.mapValues(x => "hii"+x))

    println(listt.flatMap(x=>List(x,x*2)))


  }
}
