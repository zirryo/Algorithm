import kotlin.math.ceil
val br = System.`in`.bufferedReader()
var bridges = 0
fun main() {
    val (N, L) = br.readLine().split(" ").map { it.toInt() }
    val pools = mutableListOf<Pair<Int, Int>>().apply {
        repeat(N) {
            val (s, e) = br.readLine().split(" ").map { it.toInt() }
            add(Pair(s, e))
        }
    }.sortedBy { it.first }

    var rightEdge = -1
    for(pool in pools) {
        if(rightEdge <= pool.first) rightEdge = getRight(pool.first, pool.second, L)
        else if (rightEdge < pool.second) rightEdge = getRight(rightEdge, pool.second, L)

        if(rightEdge >= pools[N-1].second) break
    }
    println(bridges)
}
fun getRight(s: Int, e:Int, L:Int): Int {
    val cnt = ceil((e - s) / L.toDouble()).toInt()
    bridges += cnt
    return s + cnt * L
}