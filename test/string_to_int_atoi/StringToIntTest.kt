package string_to_int_atoi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringToIntTest {


    @Test
    fun `for input string "42" returns int 42`() {
        val input = "42"

        assertThat( input.toAtoiInteger()).isEqualTo(42)
    }

    @Test
    fun `for input string "+42" returns int 42`() {
        val input = "+42"

        assertThat( input.toAtoiInteger()).isEqualTo(42)
    }

    @Test
    fun `for input string "-42" returns int -42`() {
        val input = "-42"

        assertThat( input.toAtoiInteger()).isEqualTo(-42)
    }

    @Test
    fun `for input string "4193 with words" returns int 4193`() {
        val input = "4193 with words"

        assertThat( input.toAtoiInteger()).isEqualTo(4193)
    }

    @Test
    fun `for input string "words and 987" returns int 0`() {
        val input = "words and 987"

        assertThat( input.toAtoiInteger()).isEqualTo(0)
    }

    @Test
    fun `for input string with too small number returns min possible int`() {
        val input = "-91283472332"

        assertThat( input.toAtoiInteger()).isEqualTo(Int.MIN_VALUE)
    }

    @Test
    fun `for input string with too big number returns max possible int`() {
        val input = "91283472332"

        assertThat( input.toAtoiInteger()).isEqualTo(Int.MAX_VALUE)
    }

    @Test
    fun `for empty input string returns 0`() {
        val input = ""

        assertThat( input.toAtoiInteger()).isEqualTo(0)
    }

    @Test
    fun `for empty input string with leading white spaces returns 0`() {
        val input = "\n \n    "

        assertThat( input.toAtoiInteger()).isEqualTo(0)
    }

    @Test
    fun `for input string with leading white spaces and too big number returns max possible int`() {
        val input = "              91283472332"

        assertThat( input.toAtoiInteger()).isEqualTo(Int.MAX_VALUE)
    }

    @Test
    fun `for too long input string throws IllegalStateException with proper message`() {
        val input = "1".repeat(201)

        assertThrows<NumberFormatException> { input.toAtoiInteger() }
    }
}