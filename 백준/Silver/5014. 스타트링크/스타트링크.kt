import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (F, S, G, U, D) = readLine().split(" ").map { it.toInt() }
    val upDown = intArrayOf(U, -D)
    val cntList = IntArray(F + 1) { 0 }
    val visited = BooleanArray (F + 1) { false }
    val q: Queue<Int> = LinkedList()
    q.add(S)
    visited[S] = true

    while (!q.isEmpty()) {
        val cur = q.poll()
        if(cur == G) {
            break
        }
        for(d in upDown) {
            if(cur + d in 1..F && !visited[cur + d]) {
                q.add(cur + d)
                cntList[cur + d] = cntList[cur] + 1
                visited[cur + d] = true
            }
        }
    }
    if(visited[G]) println(cntList[G])
    else println("use the stairs")
}