import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()

    val isPrime = BooleanArray(k + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..sqrt(k.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..k step i) {
                isPrime[j] = false
            }
        }
    }

    val primes = mutableListOf<Int>()
    for (i in 2..k) {
        if (isPrime[i]) {
            primes.add(i)
        }
    }

    var count = 0
    for (i in 1..n) {
        var temp = i
        var isKSejunNumber = true
        for (prime in primes) {
            while (temp % prime == 0) {
                temp /= prime
            }
        }
        // k 이하의 소수로 소인수분해가 가능하다면 temp = 1 이므로, 1이 아니라면 K-세준수가 아님.
        if (temp != 1) {
            isKSejunNumber = false
        }
        if (isKSejunNumber) count++
    }
    println(count)
}
