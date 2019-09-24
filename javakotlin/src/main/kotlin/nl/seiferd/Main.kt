package nl.seiferd

fun List<String>.startsWith(char: Char): List<String> = this.filter { it.startsWith(char) }

fun List<Point>.closest(): Point = sorted().first()
fun List<Point>.furthest(): Point = sorted().last()

infix fun List<Point>.`can I find?`(p: Point): Boolean = this.any { it == p } // Possible but never should be done outside of testcases

private fun List<Point>.sorted(): List<Point> = this.sortedWith(compareBy(Point::x, Point::y))