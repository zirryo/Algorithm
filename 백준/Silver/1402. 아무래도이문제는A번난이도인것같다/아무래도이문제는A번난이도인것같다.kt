import java.lang.StringBuilder

fun main() {
    val T = readln().toInt()
    val result = StringBuilder()

    repeat(T) {
        readln()
        result.append("yes\n")
    }

    println(result)
}
