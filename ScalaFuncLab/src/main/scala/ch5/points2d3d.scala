object points2d3d extends App {
    case class Point(x: Int, y: Int)

    {
        val points = List(1).flatMap(x => List(-2, 7).map(y => Point(x, y)))

        val points2 = List(1).flatMap(x => List(-2, 7, 10).map(y => Point(x, y)))

        val points3 = List(1, 2).flatMap(x => List(-2, 7).map(y => Point(x, y)))

        val points4 = List.empty[Int].flatMap(x => List(-2, 7).map(y => Point(x, y)))

        assert(points == List(Point(1, -2), Point(1, 7)))
        assert(List(1).flatMap(x => List(-2, 7, 10).map(y => Point(x, y))).size == 3)
        assert(List(1, 2).flatMap(x => List(-2, 7).map(y => Point(x, y))).size == 4)
        assert(List.empty[Int].flatMap(x => List(-2, 7).map(y => Point(x, y))).size == 0)
    }

    {
        val xs = List(1)
        val ys = List(-2, 7)

        assert(xs.flatMap(x => ys.map(y => Point(x, y))) == List(Point(1, -2), Point(1, 7)))

        assert((for {
            x <- xs
            y <- ys
        } yield Point(x, y)) == List(Point(1, -2), Point(1, 7)))

        val zs = List(3, 4)

        case class Point3d(x: Int, y: Int, z: Int)

        assert((for {
            x <- xs
            y <- ys
            z <- zs
        } yield Point3d(x, y, z)) == List(
            Point3d(1, -2, 3), Point3d(1, -2, 4),
            Point3d(1, 7, 3), Point3d(1, 7, 4)
        ))

        assert(
            xs.flatMap(x => 
                ys.flatMap(y => 
                    zs.map(z => 
                        Point3d(x, y, z)
                    )
                )
            ) 
        == List(
            Point3d(1, -2, 3), Point3d(1, -2, 4),
            Point3d(1, 7, 3), Point3d(1, 7, 4)
        ))

    }
}