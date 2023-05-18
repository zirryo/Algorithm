import java.util.TreeMap

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val map = TreeMap<String, Double>()
    var total = 0

    while (true) {
        val tree = br.readLine() ?: break
        map[tree] = map.getOrDefault(tree, 0.0) + 1
        total++
    }

    map.forEach {
        bw.write("${it.key} ${String.format("%.4f", it.value / total * 100)}\n")
    }

    bw.close()
}