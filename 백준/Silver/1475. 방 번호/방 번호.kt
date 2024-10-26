import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()

    val counts = IntArray(10)
    for (ch in n) {
        counts[ch - '0']++
    }
    
    counts[6] = (counts[6] + counts[9] + 1) / 2
    counts[9] = 0 
    
    println(counts.maxOrNull())
}
