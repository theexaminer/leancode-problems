package `3sum`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TripletsSumTest {

    @Test
    fun `for empty input list returns empty output list`() {
        val input = listOf<Int>()

        assertThat(input.`3sum`() == listOf<Int>())
    }

    @Test
    fun `for input list with length 1 returns empty output list`() {
        val input = listOf(0)

        assertThat(input.`3sum`() == listOf<Int>())
    }

    @Test
    fun `for input list with length 2 returns empty output list`() {
        val input = listOf(1,-1)

        assertThat(input.`3sum`() == listOf<Int>())
    }

    @Test
    fun `for input list (-1,0,1,2,-1,-4) returns output ((-1,-1,2),(-1,0,1))`() {
        val input = listOf(-1,0,1,2,-1,-4)

        assertThat(input.`3sum`() == listOf(listOf(-1,-1,2), listOf(-1,0,1)))
    }

}