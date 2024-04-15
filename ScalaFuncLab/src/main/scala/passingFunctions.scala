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
  {
    def score(word: String): Int = word.replaceAll("a", "").length
    val words = List("scala", "java", "haskell")
    val sortedWords = words.sortBy(score)
    assert(sortedWords == List("java", "scala", "haskell"))
    assert(List("java", "scala", "haskell").sortBy(score) == sortedWords)
  }
}