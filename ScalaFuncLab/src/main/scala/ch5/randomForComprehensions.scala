object randomForComprehensions extends App {

  assert((for {
    a <- List[Int](1, 2)
    b <- List[Int](10, 100)
    c <- List[Double](0.5, 0.7)
    d <- List[Int](3)
  } yield (a * b * c + d).toString + "km") ==
    List("8.0km", "10.0km", "53.0km", "73.0km", "13.0km", "17.0km", "103.0km", "143.0km"))

  assert((for {
    greeting <- Set("Hello", "Hi there")
    name     <- Set("Alice", "Bob")
  } yield s"$greeting, $name!") ==
    Set("Hello, Alice!", "Hello, Bob!", "Hi there, Alice!", "Hi there, Bob!"))

  assert((for {
    a <- List(1, 2)
    b <- Set(2, 1)
  } yield a * b) ==
    List(2, 1, 4, 2))

}
