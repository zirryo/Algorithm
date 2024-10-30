fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val m = br.readLine().toInt()

    val prefixSum = IntArray(n + 1)
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
    }

    val sb = StringBuilder()
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map{ it.toInt() }
        sb.append(prefixSum[j] - prefixSum[i - 1]).append("\n")
    }

    println(sb)
}