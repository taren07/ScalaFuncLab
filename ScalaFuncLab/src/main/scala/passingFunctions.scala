object passingFunctions extends App {
  {
    def inc(x: Int): Int = x + 1

    println(inc(2))

    def score(word: String): Int = word.replaceAll("a", "").length
    println(score("java"))
    assert(score("java") == 2)

    val words = List("scala", "java", "haskell")
    println(words.sortBy(score))
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

  // Practicing map
  {

    def numberOfS(s: String): Int = s.length - s.replaceAll("s", "").length
    val numberOfSs = List("scala", "java", "haskell").map(numberOfS)
    println(numberOfSs)
    assert(numberOfSs == List(1, 0, 1))

    def negative(i: Int): Int = -i
    val negatives = List(5, 1, 2, 4, 0).map(negative)
    assert(negatives == List(-5, -1, -2, -4, 0))
    println(negatives)

    def double(i: Int): Int = i * 2
    val doubles = List(5, 1, 2, 4, 0).map(double)
    assert(doubles == List(10, 2, 4, 8, 0))
    println(doubles)
  }
}