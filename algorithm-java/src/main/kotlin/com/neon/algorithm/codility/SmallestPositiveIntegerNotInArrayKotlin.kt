package com.neon.algorithm.codility

class SmallestPositiveIntegerNotInArrayKotlin {
    companion object {
        fun findSmallestPositiveInteger(array: IntArray): Int {
            requireNotNull(array) { "Array should not be zero" }

            if (array.isEmpty()) return 1

            val positiveNumbers = array.filter { it > 0 }.distinct().sorted()
            if (positiveNumbers.isEmpty()) return 1

            for (index in 0 until positiveNumbers.size - 1) {
                if (positiveNumbers[index] + 1 != positiveNumbers[index + 1]) return positiveNumbers[index] + 1
            }

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
            return if (result > 0) min - 1 else max + 1
        }
    }
}