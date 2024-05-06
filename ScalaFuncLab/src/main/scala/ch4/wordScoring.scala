object wordScoring extends App {

    def score(word: String): Int = word.replaceAll("a", "").length

    {
        assert(List("rust", "java").sortBy(score) == List("java", "rust"))
    }

    val words = List("scala", "java", "haskell", "golang", "rust")

    {
        val wordRanking = words.sortBy(score).reverse
        assert(wordRanking == List("java", "scala", "haskell", "golang", "rust"))
    }

    {
        def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
            def negativeScore(word: String): Int = -wordScore(word)
            words.sortBy(negativeScore)
        }
        assert(rankedWords(score, List("rust", "java")) == List("rust", "java"))

        val wordRanking = rankedWords(score, words)
        assert(wordRanking == List("haskell", "rust", "scala", "java", "ada"))
    }

    {
        def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
            words.sortBy(wordScore).reverse
        }

        assert(rankedWords(score, List("rust", "java")) == List("java", "rust"))

        {
            val wordRanking = rankedWords(score, words)
            assert(wordRanking == List("java", "scala", "haskell", "golang", "rust"))
        }

        def scoreWithBonus(word: String): Int = {
            val base = score(word)
            if (word.contains("c")) base + 5 else base
        }

        {
            val wordRanking = rankedWords(scoreWithBonus, words)
            assert(wordRanking == List("java", "scala", "haskell", "golang", "rust"))
        }

        def bonus(word: String): Int = if (word.contains("c")) 5 else 0

        {
            val wordRanking = rankedWords(w => score(w) + bonus(w), words)
            assert(wordRanking == List("java", "scala", "haskell", "golang", "rust"))
        }

        def penalty(word: String): Int = if (word.contains("s")) 7 else 0

        {
            val wordRanking = rankedWords(w => score(w) + bonus(w) - penalty(w), words)
            assert(wordRanking == List("java", "scala", "haskell", "golang", "rust"))
        }

        def wordScores(wordScore: String => Int, words: List[String]): List[String] = {
            words.map(wordScore)
        }

        assert(wordScores(score, List("rust", "java")) == List(4, 2))

        {
            val scores = wordScores(w => score(w) + bonus(w) - penalty(w), words)
            assert(scores == List(1, 2, 3, 4, 4))
        }

        {
            def highScoringWords(wordScore: String => Int, words: List[String]): List[String] = {
                words.filter(word => wordScore(word) > 1)
            }

            assert(highScoringWords(score, List("rust", "java")) == List("java"))
        }

        // Next line: 107
    }
}