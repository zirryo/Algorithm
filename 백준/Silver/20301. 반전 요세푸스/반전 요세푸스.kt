import java.util.ArrayDeque

fun main() {
    val (N, K, M) = readln().split(" ").map { it.toInt() }
    val dq = ArrayDeque<Int>().apply { addAll(1..N) }
    val sb = StringBuilder()
    var dir = true // true - 정방향, false - 역방향
    var cnt = 0

    while (dq.isNotEmpty()) {
        if (dir) {
            repeat(K - 1) {
                dq.addLast(dq.removeFirst())
            }
            sb.append(dq.removeFirst()).append("\n")
        } else {
            repeat(K - 1) {
                dq.addFirst(dq.removeLast())
            }
            sb.append(dq.removeLast()).append("\n")
        }

        cnt++
        if (cnt % M == 0) {
            dir = !dir
        }
    }

    println(sb)
}