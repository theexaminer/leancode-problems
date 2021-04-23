package non_decreasing_array

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NonDecreasingArrayTest {

    @Test
    fun `for (4,2,3) returns true by modify the first 4 to 1 `() {
        val nums = listOf(4,2,3).asSequence()

        val result = checkArray(nums)

        Assertions.assertTrue(result)
    }



    @Test
    fun `for (0,0,0,0) returns true`() {
        val nums = listOf(0,0,0,0).asSequence()

        val result = checkArray(nums)

        Assertions.assertTrue(result)
    }

    @Test
    fun `for (0,0,0,1) returns true`() {
        val nums = listOf(0,0,0,1).asSequence()

        val result = checkArray(nums)

        Assertions.assertTrue(result)
    }

    @Test
    fun `for (0,3,4,2) returns true`() {
        val nums = listOf(0,0,0,1).asSequence()

        val result = checkArray(nums)

        Assertions.assertTrue(result)
    }

    @Test
    fun `for (0,3,4,5,10) returns true`() {
        val nums = listOf(0,3,4,5,10).asSequence()

        val result = checkArray(nums)

        Assertions.assertTrue(result)
    }

    @Test
    fun `for (4,2,1) returns false`() {
        val nums = listOf(4,2,1).asSequence()

        val result = checkArray(nums)

        Assertions.assertFalse(result)
    }

    @Test
    fun `for (100,99,98,96,95,99,100) returns false`() {
        val nums = listOf(100,99,98,96,95,99,100).asSequence()

        val result = checkArray(nums)

        Assertions.assertFalse(result)
    }
}