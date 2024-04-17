object passingFunctions extends App {
  {
    def inc(x: Int): Int = x + 1
    def score(word: String): Int = word.replaceAll("a", "").length
    assert(score("java") == 2)

    val words = List("scala", "java", "haskell")
    assert(words.sortBy(score) == List("java", "scala", "haskell"))
  }

  // sortBy
  {
    def score(word: String): Int = word.replaceAll("a", "").length
    val words = List("scala", "java", "haskell")
    val sortedWords = words.sortBy(score)
    assert(sortedWords == List("java", "scala", "haskell"))
    assert(List("java", "scala", "haskell").sortBy(score) == sortedWords)
  }

  // Practicing function passing
  {
    def len(s: String): Int = s.length
    val byLength = List("scala", "java", "haskell").sortBy(len)
    assert(byLength == List("java", "scala", "haskell"))

    def numberOfS(s: String): Int = s.length - s.replaceAll("s", "").length
    val byNumberOfS = List("java", "scala", "haskell").sortBy(numberOfS)
    assert(byNumberOfS == List("java", "scala", "haskell"))

    def negative(i: Int): Int = -i
    val ascending = List(5, 1, 2, 4, 3).sortBy(negative)
    assert(ascending == List(5, 4, 3, 2, 1))
  
    def negativeNumberOfS(s: String): Int = -numberOfS(s)
    val byNegativeNumberOfS = List("haskell", "scala", "java").sortBy(negativeNumberOfS)
    assert(byNegativeNumberOfS == List("haskell", "scala", "java"))
  }

  // Practicing map
  {
    def numberOfS(s: String): Int = s.length - s.replaceAll("s", "").length
    val numberOfSs = List("scala", "java", "haskell").map(numberOfS)
    assert(numberOfSs == List(1, 0, 1))

    def negative(i: Int): Int = -i
    val negatives = List(5, 1, 2, 4, 0).map(negative)
    assert(negatives == List(-5, -1, -2, -4, 0))

    def double(i: Int): Int = i * 2
    val doubles = List(5, 1, 2, 4, 0).map(double)
    assert(doubles == List(10, 2, 4, 8, 0))
  }

  {
    def len(s: String): Int = s.length
    val longWords = List("scala", "java", "haskell").filter(word => len(word) < 5)
    assert(longWords == List("java"))

    def numberOfS(s: String): Int = s.length - s.replaceAll("s", "").length
    val withLotsS = List("scala", "java", "haskell").filter(word => numberOfS(word) > 2)
    assert(withLotsS == List.empty)

    def odd(i: Int): Boolean = i % 2 == 1
    val odds = List(5, 1, 2, 4, 0).filter(odd)
    assert(odds == List(5, 1))

    def largerThan4(i: Int): Boolean = i > 4
    val large = List(5, 1, 2, 4, 0).filter(largerThan4)
    assert(large == List(5))
  }
}