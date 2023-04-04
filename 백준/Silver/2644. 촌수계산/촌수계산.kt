val br = System.`in`.bufferedReader()
var result = -1
var visited = BooleanArray(101) { false }

fun main() {
    val n = br.readLine().toInt()
    val (s, e) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val relation = Array(n+1) {ArrayList<Int>()}
    for(i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        relation[a].add(b)
        relation[b].add(a)
    }
    dfs(s, e, s, 0, relation)
    println(result)
}
fun dfs(s: Int, e: Int, person: Int, depth: Int, relation: Array<ArrayList<Int>>) {
    visited[person] = true
    if(person == e) {
        result = depth
        return
    }
    for(next in relation[person]) {
        if(!visited[next]) {
            dfs(s, e, next, depth+1, relation)
        }
    }
}