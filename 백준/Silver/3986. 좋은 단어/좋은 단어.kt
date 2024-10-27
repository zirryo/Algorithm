import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0

    repeat(n) {
        val word = br.readLine()
        if (isGoodWord(word)) result++
    }

    println(result)
}

fun isGoodWord(word: String): Boolean {
    val stack = mutableListOf<Char>()

    for (char in word) {
        if (stack.isNotEmpty() && stack.last() == char) {
            stack.removeAt(stack.size - 1)
        } else {
            stack.add(char)
        }
    }

    return stack.isEmpty()
}
