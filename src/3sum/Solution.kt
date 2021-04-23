package `3sum`

import kotlin.math.absoluteValue
import kotlin.math.sign

/*
15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?

Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.
*/

fun List<Int>.calculate3Sum(): List<List<Int>> {
    if (this.size in 0..2) return listOf(listOf())

    val triples = combinationsOfListEntries(3)

    return triples
        .map { it.sorted() }
        .distinct()
        .filter { it.sum() == 0 }
}

private fun List<Int>.combinationsOfListEntries(size: Int): List<List<Int>> {
    val combinations: MutableCollection<List<Int>> = ArrayList()
    this.forEach { i ->
        this.drop(indexOf(i) + 1).forEach { j ->
            this.drop(indexOf(j) + 1).forEach { k ->
                combinations.add(listOf(i, j, k))
            }
        }
    }
    return combinations.filter { it.size == size }
}

private fun List<Int>.partition(): Pair<List<Int>, List<Int>> =
    Pair(this.filter { it < 0 }.sorted(), this.filter { it >= 0 }.sorted())

fun List<Int>.`3sum`(): Set<Triple<Int, Int, Int>> {
    if(size < 3) return emptySet()

    return partition { it < 0 }.let { (negatives, nonNegatives) ->

        negatives.flatMap { nonNegatives.`2sum`(-it).map { (s1, s2) -> Triple(s1, s2, it) } } +
                nonNegatives.flatMap { negatives.`2sum`(-it).map { (s1, s2) -> Triple(s1, s2, it) } }
    }.toSet()
}


fun List<Int>.`2sum`(c: Int = 0): Set<Pair<Int, Int>> {
    if(size < 2) return emptySet()

    val firstLastPair = when (first() + last()) {
        c -> setOf(first() to last())
        else -> emptySet()
    }

    return firstLastPair + drop(1).`2sum`(c) + dropLast(1).`2sum`(c)
}

