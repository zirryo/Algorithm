import java.lang.StringBuilder

val br = System.`in`.bufferedReader()
fun main() {
    val words = hashMapOf<String, Int>()
    val token = br.readLine().split(" ")
    val n = token[0].toInt()
    val m = token[1].toInt()
    repeat(n) {
        val str = br.readLine()
        if (str.length >= m) {
            words[str] = words.getOrDefault(str, 0) + 1
        }
    }
    val answer = StringBuilder()
    val sorted = words.entries.sortedWith(kotlin.Comparator {o1, o2 ->
        when {
            o1.value != o2.value -> o2.value - o1.value // 값 내림차순
            o1.key.length != o2.key.length -> o2.key.length - o1.key.length // 키 길이 내림차순
            else -> o1.key.compareTo(o2.key) // 키 오름차순
        }
    })
    sorted.forEach { answer.append("${it.key}\n") }
    println(answer)
}