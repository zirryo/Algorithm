import java.lang.StringBuilder
import java.util.StringTokenizer

val dr = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
val dc = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>
var n = 0
var m = 0
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        cnt = 0
        val token = readLine().split(" ").map { it.toInt() }
        n = token[1]
        m = token[0]
        if(n==0 && m==0) break
        map = Array(n) { Array(m) { 0 } }
        visited = Array(n) { Array(m) { false } }

        for(i in 0 until n) {
            val st = StringTokenizer(readLine())
            for(j in 0 until m) {
                map[i][j] = st.nextToken().toInt()
            }
        }
        repeat(n) { i ->
            repeat(m) { j ->
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt++
                    visited[i][j] = true
                    dfs(i, j)
                }
            }
        }
        sb.append("$cnt\n")
    }
    print(sb)
}
fun dfs(r: Int, c: Int) {
    for(i in 0 until 8) {
        val nr = dr[i] + r
        val nc = dc[i] + c
        if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue
        if(map[nr][nc] == 1 && !visited[nr][nc]) {
            visited[nr][nc] = true
            dfs(nr, nc)
        }
    }
}