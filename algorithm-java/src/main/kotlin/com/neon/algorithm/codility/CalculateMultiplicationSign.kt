package com.neon.algorithm.codility

/** Calculate, what sign of output number will be, based on input array */
class CalculateMultiplicationSign {
    companion object {
        fun solution(array: IntArray): Int {
            if (array.isEmpty()) throw IllegalArgumentException("Array must not be empty")

            if (array.contains(0)) return 0
            val countOfMinuses = array.count { it < 0 }
            return if (countOfMinuses % 2 == 0) 1 else -1
        }
    }
}