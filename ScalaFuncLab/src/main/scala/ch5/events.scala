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



}