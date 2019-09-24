package nl.seiferd

data class Point(var x: Int, var y: Int) {

    infix operator fun plus(other: Point): Point {
        this.x += other.x
        this.y += other.y
        return this
    }

    infix operator fun minus(other: Point): Point {
        this.x -= other.x
        this.y -= other.y
        return this
    }

    operator fun rangeTo(other: Point): Point = this minus other

    infix fun distanceTo(other: Point): Point = this .. other

}