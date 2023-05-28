fun main() {
    val br = System.`in`.bufferedReader()
    val token = br.readLine().split(" ").map { it.toInt() }
    var n = token[0]
    val k = token[1]
    var result = 0

    while (Integer.bitCount(n) > k) {
        result += n and -n
        n += n and -n
    }
    println(result)
}