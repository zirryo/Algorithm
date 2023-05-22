import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var token = br.readLine().split(" ").map { it.toInt() }
    val n = token[0]
    val m = token[1]
    val indegree = IntArray (n+1) { 0 }
    val cnt = IntArray (n+1) { 1 }
    val list : MutableList<MutableList<Int>> = ArrayList()
    repeat(n+1) {
        list.add(ArrayList())
    }
    repeat(m) {
        token = br.readLine().split(" ").map { it.toInt() }
        list.get(token[0]).add(token[1])
        indegree[token[1]]++
    }

    val q : Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (indegree[i] == 0) q.add(i)
    }

    while (!q.isEmpty()) {
        val cur = q.poll()!!
        list.get(cur).forEach {
            indegree[it]--
            cnt[it] = max(cnt[cur] + 1, cnt[it])
            if (indegree[it] == 0) {
                q.add(it)
            }
        }
    }
    for (i in 1..n) {
        bw.write(cnt[i].toString() + " ")
    }
    bw.flush()
    bw.close()
}