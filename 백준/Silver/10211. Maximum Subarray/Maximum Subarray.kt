fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val N = readln().toInt()
        val arr = readln().split(" ").map { it.toInt() }

        var maxSum = arr[0]
        var currentSum = arr[0]

        for (i in 1 until N) {
            currentSum = maxOf(arr[i], currentSum + arr[i])
            maxSum = maxOf(maxSum, currentSum)
        }

        sb.append("$maxSum\n")
    }

    print(sb)
}
