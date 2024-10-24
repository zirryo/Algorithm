import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()

    // 홀수번 뒤집혀서 백기로 남는 경우 -> 완전제곱수
    val result = sqrt(n.toDouble()).toInt()

    println(result)
}
