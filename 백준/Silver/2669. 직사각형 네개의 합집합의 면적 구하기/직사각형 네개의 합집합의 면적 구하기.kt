import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val grid = Array(100) { BooleanArray(100) }

    repeat(4) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        for (x in x1 until x2) {
            for (y in y1 until y2) {
                grid[x][y] = true
            }
        }
    }

    var area = 0
    for (x in 0 until 100) {
        for (y in 0 until 100) {
            if (grid[x][y]) area++
        }
    }

    println(area)
}
