package nl.seiferd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PointTest {

    @Test
    fun `Assert that x5y5 + x5y5 is equal to x10y10`() {
        val expected = Point(10, 10)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 5)

        val newPoint = pointOne + pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that x5y5 + x2y5 is equal to x7y10`() {
        val expected = Point(7, 10)

        val pointOne = Point(5, 5)
        val pointTwo = Point(2, 5)

        val newPoint = pointOne + pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that x5y5 + x5y2 is equal to x10y7`() {
        val expected = Point(10, 7)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 2)

        val newPoint = pointOne + pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that x5y5 - x5y5 is equal to x0y0`() {
        val expected = Point(0, 0)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 5)

        val newPoint = pointOne - pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that x5y5 - x2y5 is equal to x3y0`() {
        val expected = Point(3, 0)

        val pointOne = Point(5, 5)
        val pointTwo = Point(2, 5)

        val newPoint = pointOne - pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that x5y5 - x5y2 is equal to x0y3`() {
        val expected = Point(0, 3)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 2)

        val newPoint = pointOne - pointTwo

        assertEquals(expected, newPoint)
    }

    @Test
    fun `Assert that the distance from x5y5 to x5y2 is equal to x0y3`() {
        val expected = Point(0, 3)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 2)

        val distance = pointOne distanceTo pointTwo

        assertEquals(expected, distance)
    }

    @Test
    fun `Assert that the range from x5y5 to x5y2 is equal to x0y3`() {
        val expected = Point(0, 3)

        val pointOne = Point(5, 5)
        val pointTwo = Point(5, 2)

        val distance = pointOne .. pointTwo

        assertEquals(expected, distance)
    }
}