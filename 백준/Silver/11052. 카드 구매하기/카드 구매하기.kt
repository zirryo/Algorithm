import kotlin.math.max

val br = System.`in`.bufferedReader()
fun main() {
    val n = br.readLine().toInt()
    var cost = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    cost = intArrayOf(0).plus(cost)
    val dp = IntArray (n+1) { 0 }

    for (i in dp.indices) {
        for (j in 0..i) {
            dp[i] = max(dp[i], cost[j] + dp[i-j])
        }
    }
    println(dp[n])
}