val br = System.`in`.bufferedReader()
var n = 0
fun main() {
    n = br.readLine().toInt()
    val numList = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    var answer = 0

    if(numList.sum() <= m) {
        answer = numList.max()
    } else {
        var lo = 1
        var hi = numList.max()
        while (lo <= hi) {
            var mid = (lo + hi) / 2
            if(sumList(numList, mid) > m) {
                hi = mid - 1
            } else {
                lo = mid + 1
                answer = mid
            }
        }
    }
    println(answer)
}
fun sumList(list : List<Int>, midVal : Int) : Int {
    var sum = 0
    for (i in list.indices) {
        if(list[i] < midVal) sum += list[i]
        else sum += midVal
    }
    return sum
}