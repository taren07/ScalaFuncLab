import bookAdaptations.Book

object bookAdaptations extends App {
    case class Book(title: String, authors: List[String])
    case class Movie(title: String)

    {
        val books = List(
            Book("FP in Scala", List("Chiusano", "Bjarnason")),
            Book("The Hobbit", List("Tolkien")),
            Book("Modern Java in Action", List("Urma", "Fusco", "Mycroft"))
        )

        val scalaBooksQty1 = books
            .map(_.title)
            .filter(_.contains("Scala"))
            .size
            assert(scalaBooksQty1 == 1)

        val scalaBooksQty2 = books
            .map(book => book.title)
            .filter(title => title.contains("Scala"))
            .size
            assert(scalaBooksQty2 == 1)
    }

    val books = List(
        Book("FP in Scala", List("Chiusano", "Bjarnason")),
        Book("The Hobbit", List("Tolkien"))
    )

    def bookAdaptations(author: String): List[Movie] = {
        if (author == "Tolkien") List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
        else List.empty
    }

    val a1 = books.map(_.authors)
    assert(a1 == List(List("Chiusano", "Bjarnason"), List("Tolkien")))

    val a2 = books.map(_.authors).flatten
    assert(a2 == List("Chiusano", "Bjarnason", "Tolkien"))

    val a3 = books.flatMap(_.authors)
    assert(a2 == a3)
}            