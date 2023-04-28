val br = System.`in`.bufferedReader()
fun main() {
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    if(n == 1 || n == m) {
        println(1)
        return
    }
    val arr = IntArray(n+1-m) {0}
    arr[0] = 1
    arr[1] = 1
    for (i in 2 until arr.size) {
        arr[i] = arr[i-1] + arr[i-2]
    }
    var first = 0
    var result = 1
    for(i in 1..m) {
        var second = br.readLine().toInt()
        result *= (arr[second-first-1])
        first = second
    }
    result *= (arr[n-first])
    println(result)
}