import java.lang.StringBuilder

val br = System.`in`.bufferedReader()
val sb = StringBuilder()
fun main() {
    var T = br.readLine().toInt()
    while(T-- > 0) {
        val n = br.readLine().toInt()
        var arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val res = {n1: Int, arr1: IntArray ->
            var ans: Long = 0
            var maxVal = 0
            for(i in n1-1 downTo 0) {
                if(arr1[i] < maxVal) ans += (maxVal - arr1[i])
                else maxVal = arr1[i]
            }
            ans
        }
        sb.append(res(n, arr)).append("\n")
    }
    println(sb)
}