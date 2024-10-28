import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toBigInteger() }

    val gcd = a.gcd(b)
    val lcm = (a * b) / gcd

    println(lcm)
}
