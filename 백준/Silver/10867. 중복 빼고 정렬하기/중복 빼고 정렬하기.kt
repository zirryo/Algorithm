import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }.toSet()
    
    val sortedNumbers = numbers.sorted()
    
    val sb = StringBuilder()
    for (num in sortedNumbers) {
        sb.append(num).append(" ")
    }
    println(sb.toString().trim())
}

