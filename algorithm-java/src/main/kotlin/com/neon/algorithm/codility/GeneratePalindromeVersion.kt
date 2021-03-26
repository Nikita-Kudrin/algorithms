package com.neon.algorithm.codility

/** Replace question mark with random symbol.
 * If not possible to generate palindrome - return NO
 * */
class GeneratePalindromeVersion {
    companion object {
        const val NO_STRING = "NO"
        const val QUESTION_MARK = '?'

        fun solution(input: String): String {

            if (input.isNullOrBlank()) return NO_STRING

            val output = input.toCharArray()
            val length = output.size - 1

            for (index in 0 until length) {
                var leftHandSymbol = output[index]
                var rightHandSymbol = output[length - index]

                if (leftHandSymbol != rightHandSymbol) {
                    if (leftHandSymbol == QUESTION_MARK) {
                        output[index] = rightHandSymbol
                    } else if (rightHandSymbol == QUESTION_MARK) {
                        output[length - index] = leftHandSymbol
                    } else return NO_STRING
                } else {
                    if (leftHandSymbol == QUESTION_MARK && rightHandSymbol == QUESTION_MARK) {
                        output[index] = ('a'..'z').random()
                        output[length - index] = output[index]
                    }
                }
            }

            return String(output)
        }
    }
}