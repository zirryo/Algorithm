import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val t = br.readLine().toInt()

    repeat (t) {
        val st = StringTokenizer(br.readLine())

        val numbers = mutableListOf<Int>()
        while (st.hasMoreTokens()) {
            numbers.add(st.nextToken().toInt())
        }

        var maxGCD = 0
        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                maxGCD = max(maxGCD, gcd(numbers[i], numbers[j]))
            }
        }

        sb.append(maxGCD).append("\n")
    }

    print(sb.toString())
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
