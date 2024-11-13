import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    println(countHanNumbers(n))
}

fun countHanNumbers(n: Int): Int {
    if (n < 100) return n  // 1부터 n까지 모두 한수
    var count = 99  // 1부터 99까지는 모두 한수
    for (i in 100..n) {
        if (isHanNumber(i)) count++
    }
    return count
}

fun isHanNumber(number: Int): Boolean {
    val digits = number.toString().map { it - '0' }
    return (digits[0] - digits[1]) == (digits[1] - digits[2])
}
