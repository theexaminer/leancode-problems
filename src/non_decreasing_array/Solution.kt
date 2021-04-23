package non_decreasing_array

/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */

fun checkArray(nums: Sequence<Int>) =
    nums
        //.windowed(2).filter { (l1, l2) -> l1 > l2 }
        .zipWithNext()
        .evaluateUntil(2) { it.first > it.second }
        .size <= 1

fun <T> Sequence<T>.evaluateUntil(max: Int, predicate: (T) -> Boolean) =
    filter(predicate).zip((1..max).asSequence()).toList()
