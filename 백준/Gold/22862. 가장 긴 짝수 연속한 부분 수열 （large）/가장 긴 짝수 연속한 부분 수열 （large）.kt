import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = reader.readLine().split(" ").map { it.toInt() }
    val sequence = reader.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = 0
    var oddCount = 0
    var maxLength = 0
    var currentLength = 0

    while (right < n) {
        if (sequence[right] % 2 == 1) {
            oddCount++
        } else {
            currentLength++
        }

        while (oddCount > k) {
            if (sequence[left] % 2 == 1) {
                oddCount--
            } else {
                currentLength--
            }
            left++
        }

        maxLength = maxOf(maxLength, currentLength)
        right++
    }

    println(maxLength)
}
