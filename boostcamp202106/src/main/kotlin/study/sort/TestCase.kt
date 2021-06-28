package study.sort

import kotlin.random.Random

object TestCase {
    val testCase = arrayOf(
        intArrayOf(8, 1, 3, 9, 6),
        intArrayOf(6, 11, 2, 4, 39, 16),
        intArrayOf(6, 11, 2, 4, 39, 16, 6),
        intArrayOf(2, 11, 2, 11, 39, 2, 6),
        intArrayOf(13, -4, -5, 1, 13, 6, 2),
        intArrayOf(1)
    )

    val testCase30000 = IntArray(30000) { Random.nextInt(50000) }
}