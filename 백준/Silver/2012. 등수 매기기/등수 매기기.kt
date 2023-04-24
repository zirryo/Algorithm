import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() {
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(br.readLine().toInt())
    }
    list.sort()
    var result : Long = 0
    list.forEachIndexed { index, num ->
        result += abs(num - (index+1))
    }
    println(result)
}