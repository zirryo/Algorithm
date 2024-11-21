import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt() * 2
    var result = 0
    val st = StringTokenizer(br.readLine())
    val set: MutableSet<Int> = HashSet()

    for (i in 0 until N) {
        val x = st.nextToken().toInt()

        if (set.contains(x)) {
            set.remove(x)
        } else {
            set.add(x)
            result = max(result, set.size)
        }
    }

    println(result)
}
