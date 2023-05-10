import kotlin.math.max
import kotlin.math.min

val br = System.`in`.bufferedReader()
fun main() {
    val token = br.readLine().split(" ").map { it.toLong() }
    val X = token[0]
    val Y = token[1]
    val w = token[2]
    val s = token[3]
    var answer : Long = 0

    if (2 * w > s) { // 가로1 + 세로1 이동보다 대각선이 유리한 경우
        val x = max(X, Y)
        val y = min(X, Y)
        answer += (y * s) // 대각선으로 최대한 많이 이동
        if (w > s) { // 한 칸 이동할 때도 대각선이 이득인 경우
            if ((x - y) % 2 == 0L) answer += (x - y) * s
            else answer += (x - y - 1) * s + w
        } else answer += (x - y) * w
    } else answer += (X + Y) * w

    println(answer)
}