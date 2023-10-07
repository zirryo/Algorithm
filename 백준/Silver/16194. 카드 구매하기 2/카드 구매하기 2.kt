import kotlin.math.min

val br = System.`in`.bufferedReader()
fun main() {
    val n = br.readLine().toInt()
    var cost = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    cost = intArrayOf(0).plus(cost)
    val dp = IntArray (n+1) { 10000000 }
    dp[0] = 0

    for (i in dp.indices) {
        for (j in 0..i) {
            dp[i] = min(dp[i], cost[j] + dp[i-j])
        }
    }
    println(dp[n])
}