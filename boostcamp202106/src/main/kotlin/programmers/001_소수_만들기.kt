package programmers

class Solution1 {
    val isPrime = BooleanArray(3001) { true }

    fun solution(nums: IntArray): Int {
        makePrimeList()
        var ans = 0
        val size = nums.size

        for(i in 0 until size - 2) {
            for(j in (i + 1) until size - 1) {
                for(k in (j + 1) until size) {
                    if(isPrime[nums[i] + nums[j] + nums[k]]) ans++
                }
            }
        }
        return ans
    }

    fun makePrimeList() {
        isPrime[0] = false
        isPrime[1] = false

        for(num in 2..1500) {
            var next = 2 * num
            while(next <= 3000) {
                isPrime[next] = false
                next += num
            }
        }
    }
}