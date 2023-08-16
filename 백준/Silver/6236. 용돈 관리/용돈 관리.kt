fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    var l = arr.min()
    var r = arr.sum()
    val max = arr.max()
    var mid : Int
    var ans = 0

    while (l <= r) {
        mid = (l + r) / 2
        var k = mid
        var cnt = 1

        for (i in arr) {
            if (k - i < 0) {
                cnt++
                k = mid
            }
            k -= i
        }

        if (cnt > m || mid < max) {
            l = mid + 1
        } else {
            r = mid - 1
            ans = mid
        }
    }
    println(ans)
}