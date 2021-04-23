package add_two_numbers

/*
* 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
* */

fun List<Int>.toLinkedNodes(): Node =
    if (size > 1) Node(first(), next = drop(1).toLinkedNodes())
    else Node(first())

fun Node.values(): Sequence<Int> = sequenceOf(this.value) + (this.next?.values() ?: emptySequence())

data class Node(val value: Int, val next: Node? = null) {
    init {
        check(value in (0..9))
    }
}

fun maybeAdd(n1: Node?, n2: Node?, carry: Int = 0): Node? =
    if (n1 == null && n2 == null) Node(carry).takeIf { carry != 0}
    else addDigits(n1?.value ?: 0, n2?.value ?: 0, carry).let { (s, c) ->
        Node(
            value = s,
            next = maybeAdd(n1?.next, n2?.next, c)
        )
    }

private fun addDigits(d1: Int, d2: Int, carry: Int): Pair<Int, Int> =
    (d1 + d2 + carry).let {
        if (it > 9) it % 10 to 1 else it to 0
    }



