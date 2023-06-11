import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(n+1) { 0 }
    val dp = IntArray(n+1) { 0 }
    val st = StringTokenizer(br.readLine())

    for (i in n downTo 1) {
        arr[i] = st.nextToken().toInt()
    }

    for (i in 1..n) {
        dp[i] = 1
        for (j in i-1 downTo 1) {
            if (arr[j] < arr[i]) dp[i] = max(dp[j] + 1, dp[i])
        }
    }
    
    println(dp.max())
}