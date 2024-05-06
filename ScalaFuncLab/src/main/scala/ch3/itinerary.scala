object itinerary extends App {
  def replan(plan: List[String], newCity: String, beforeCity: String): List[String] = {
    val beforeCityIndex = plan.indexOf(beforeCity)
    println(beforeCityIndex)
    val citiesBefore = plan.slice(0, beforeCityIndex)
    println(citiesBefore)
    val citiesAfter = plan.slice(beforeCityIndex, plan.size)
    println(citiesAfter)
    citiesBefore.appended(newCity).appendedAll(citiesAfter)
  }

  val planA = List("Tokyo", "Osaka", "Nagoya")
  println("Plan A:" + planA)

  val planB = replan(planA, "Fukuoka", "Nagoya")
  assert(planB == List("Tokyo", "Osaka", "Fukuoka", "Nagoya"))
  println("Plan B:" + planB)

  assert(planA == List("Tokyo", "Osaka", "Nagoya"))
  println("Plan A:" + planA)
}