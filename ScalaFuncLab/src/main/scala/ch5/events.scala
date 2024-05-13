object events extends App {
    case class Event(name: String, start: Int, end: Int)
    
    {
        def parseAdHoc(name: String, start: Int, end: Int): Event = {
            if (name.size > 0 && end < 3000 & start <= end) Event(name, start, end)
            else null
        }

        assert(parseAdHoc("Apollo Program", 1961, 1972) == Event("Apollo Program", 1961, 1972))
        assert(parseAdHoc("", 1939, 1945) == null)
        assert(parseAdHoc("Event", 1949, 1945) == null)
    }

    {
        def parse(name: String, start: Int, end: Int): Option[Event] = {
            if (name.size > 0 && end < 3000 & start <= end) Some(Event(name, start, end))
            else None
        }

        assert(parse("Apollo Program", 1961, 1972) == Some(Event("Apollo Program", 1961, 1972)))
        assert(parse("", 1939, 1945) == None)
        assert(parse("Event", 1949, 1945) == None)
    }

    {
        def validateName(name: String): Option[String] = if (name.size > 0) Some(name) else None
        def validateEnd(end: Int): Option[Int] = if (end < 3000) Some(end) else None
        def validateStart(start: Int, end: Int): Option[Int] = if (start <= end) Some(start) else None

        def parse(name: String, start: Int, end: Int): Option[Event] = for {
            validName  <- validateName(name)
            validEnd   <- validateEnd(end)
            validStart <- validateStart(start, end)
        } yield Event(validName, validStart, validEnd)

        assert(parse("Apollo Program", 1961, 1972) == Some(Event("Apollo Program", 1961, 1972)))
        assert(parse("", 1939, 1945) == None)
        assert(parse("Event", 1949, 1945) == None)
    }



}