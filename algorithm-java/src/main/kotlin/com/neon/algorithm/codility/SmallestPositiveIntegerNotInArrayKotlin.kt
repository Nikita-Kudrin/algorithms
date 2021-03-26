package com.neon.algorithm.codility

class SmallestPositiveIntegerNotInArrayKotlin {
    companion object {
        fun findSmallestPositiveInteger(array: IntArray): Int {
            requireNotNull(array) { "Array should not be zero" }

            if (array.isEmpty()) return 1

            val positiveNumbers = array.filter { it > 0 }.distinct().sorted()
            if (positiveNumbers.isEmpty()) return 1

            var min = 0
            var max = 0
            if (positiveNumbers.size == 1) {
                max = positiveNumbers[0]
                min = max
            } else {
                min = positiveNumbers[0]
                max = positiveNumbers[positiveNumbers.size - 1]
            }
            val result = min - 1
            if (result > 0) return min - 1
            else {
                for (index in 0 until positiveNumbers.size - 1) {
                    if (positiveNumbers[index] + 1 != positiveNumbers[index + 1])
                        return positiveNumbers[index] + 1
                }
                return max + 1
            }
        }
    }
}