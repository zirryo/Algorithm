fun main() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().split(" ")
    val n = input[0].toLong()
    val r = input[1].toLong()

    println(n + 2 * r - 1)
}