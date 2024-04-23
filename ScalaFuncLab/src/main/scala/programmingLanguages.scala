object programmingLanguages extends App {

    case class programmingLanguage(name: String, year: Int)

    val javalang = programmingLanguage("Java", 1995)
    val scalalang = programmingLanguage("Scala", 2004)
    assert(javalang.name == "Java")
    assert(scalalang.name == "Scala")
    assert(scalalang.name.length == 5)
    assert((scalalang.year + javalang.year) / 2 == 1999)

    val languages = List(javalang, scalalang)
    assert(languages == List(ProgrammingLanguage("Java", 1995), ProgrammingLanguage("Scala", 2004)))
}