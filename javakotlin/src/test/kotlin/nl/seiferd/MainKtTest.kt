package nl.seiferd

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `Find the String that starts with a 'K' `(){
        val result = listOf("Kotlin", "Java", "Javascript").startsWith('K')

        assertEquals(1,result.size)
        assertEquals("Kotlin", result.first())
    }

    @Test
    fun `Find no String that starts with a 'K', since it's case sensitive `(){
        val result = listOf("Kotlin", "Java", "Javascript").startsWith('k')

        assertTrue(result.isEmpty())
    }

    @Test
    fun `Find the point that is the closest`(){
        val expected = Point(2, 2)
        val result = listOf(Point(2, 5), Point(2, 2), Point(6, 2)).closest()

        assertEquals(expected, result)
    }

    @Test
    fun `Find the point that is the furthest`(){
        val expected = Point(6, 7)
        val result = listOf(Point(6, 5), Point(2, 7), Point(6, 7)).furthest()

        assertEquals(expected, result)
    }

    @Test
    fun `Can I find my expected point`(){
        val expected = Point(6, 7)
        val result = listOf(Point(6, 5), Point(2, 7), Point(6, 7)) `can I find?` expected

        assertTrue(result)
    }

    @Test
    fun `Unable to find my expected point`(){
        val expected = Point(3, 3)
        val result = listOf(Point(6, 5), Point(2, 7), Point(6, 7)) `can I find?` expected

        assertFalse(result)
    }
}