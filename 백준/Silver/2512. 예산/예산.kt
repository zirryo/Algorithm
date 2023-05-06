val br = System.`in`.bufferedReader()
var n = 0
fun main() {
    n = br.readLine().toInt()
    val numList = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    var answer = 0

    if(numList.sum() <= m) {
        answer = numList[n-1]
    } else {
        var lo = 1
        var hi = numList[n-1]
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
    var idx = 0
    var sum = 0
    for (i in list.indices) {
        if(list[i] < midVal) sum += list[i]
        else {
            idx = i
            break
        }
    }
    sum += (n - idx) * midVal
    return sum
}