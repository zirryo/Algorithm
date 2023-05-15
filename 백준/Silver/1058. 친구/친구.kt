import kotlin.math.max

val br = System.`in`.bufferedReader()
fun main() {
    val n = br.readLine().toInt()
    val arr = Array(n) { CharArray(n) {'0'} }
    val twoFriend = Array(n) { IntArray(n) {0} }

    for(i in arr.indices) arr[i] = br.readLine().toCharArray()

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue
                if ((arr[i][k] == 'Y' && arr[k][j] == 'Y') || arr[i][j] == 'Y') twoFriend[i][j] = 1
            }
        }
    }

    var ans = 0
    for (i in arr.indices) ans = max(ans, twoFriend[i].sum())
    println(ans)
}