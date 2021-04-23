package add_two_numbers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {

    @Test
    fun `(0,0,0) and (0,0,0) returns (0,0,0)`() {
        val l1 = listOf(0,0,0).toLinkedNodes()
        val l2 = listOf(0,0,0).toLinkedNodes()

        val result = maybeAdd(l1,l2)?.values()?.toList()

        Assertions.assertIterableEquals(listOf(0,0,0), result)
    }

    @Test
    fun `(2,4,3) and (5,6,4) returns (7,0,8)`() {
        val l1 = listOf(2,4,3).toLinkedNodes()
        val l2 = listOf(5,6,4).toLinkedNodes()

        val result = maybeAdd(l1,l2)?.values()?.toList()

        Assertions.assertIterableEquals(listOf(7,0,8), result)
    }

    @Test
    fun `(9,9,9,9,9,9,9) and (9,9,9,9) returns (8,9,9,9,0,0,0,1)`() {
        val l1 = listOf(9,9,9,9,9,9,9).toLinkedNodes()
        val l2 = listOf(9,9,9,9).toLinkedNodes()

        val result = maybeAdd(l1,l2)?.values()?.toList()

        Assertions.assertIterableEquals(listOf(8,9,9,9,0,0,0,1), result)
    }

}