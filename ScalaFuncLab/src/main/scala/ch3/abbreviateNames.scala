object abbreviateNames extends App {
  def abbreviate(name: String): String = {
    val initial = name.substring(0, 1)
    val separator = name.indexOf(' ')
    val lastName = name.substring(separator + 1)
    initial + ". " + lastName
  }

  assert(abbreviate("Taro yamada") == "T. yamada")
  assert(abbreviate("T. yamada") == "T. yamada")
  assert(abbreviate("T yamada") == "T. yamada")
}
