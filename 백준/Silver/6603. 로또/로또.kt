import java.lang.StringBuilder

val br = System.`in`.bufferedReader()
val sb = StringBuilder()
var n = 0
fun main() {
    while(true) {
        var num = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        n = num[0]
        if(n == 0) break
        makeLotto(num, 0, 1, BooleanArray(n+1) {false})
        sb.append("\n")
    }
    println(sb)
}
fun makeLotto(num : IntArray, depth : Int, idx : Int, picked : BooleanArray) {
    if(depth == 6) {
        for (i in picked.indices) {
            if(picked[i]) sb.append(num[i]).append(" ")
        }
        sb.append("\n")
        return
    }
    for(i in idx..n) {
        picked[i] = true
        makeLotto(num, depth+1, i+1, picked)
        picked[i] = false
    }
}