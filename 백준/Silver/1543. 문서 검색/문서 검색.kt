val br = System.`in`.bufferedReader()
fun main() {
    val n = br.readLine()
    val m = br.readLine()
    var cnt = 0
    var idx = 0
    while (n.length >= idx + m.length) {
        if (n.substring(idx, idx + m.length) == m) {
            cnt++
            idx += (m.length - 1)
        }
        idx++
    }
    println(cnt)
}