import java.util.LinkedHashMap

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val map = hashMapOf<Int, Int>()
    var total = 0L

    repeat(n) {
        val info = br.readLine().split(" ").map { it.toInt() }
        val a = info[0]
        val x = info[1]
        map[a] = x
        total += x
    }

    val sorted = LinkedHashMap<Int, Int>()
    map.entries.sortedBy { it.key }.forEach { sorted[it.key] = it.value }

    var cnt = 0L
    var result = 0L
    run {
        sorted.forEach {
            cnt += it.value
            if (cnt >= ((total+1) / 2)) {
                result = it.key.toLong()
                return@run
            }
        }
    }
    println(result)
}