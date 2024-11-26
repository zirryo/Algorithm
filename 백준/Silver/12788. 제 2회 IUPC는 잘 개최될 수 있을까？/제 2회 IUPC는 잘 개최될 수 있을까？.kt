fun main() {
    val n = readln().toInt()
    val (m, k) = readln().split(" ").map { it.toInt() }
    val pen = readln().split(" ").map { it.toInt() }.sortedDescending()

    var totalPen = 0
    var result = 0

    for (p in pen) {
        totalPen += p
        result++
        if (totalPen >= m * k) {
            println(result)
            return
        }
    }

    println("STRESS")
}
