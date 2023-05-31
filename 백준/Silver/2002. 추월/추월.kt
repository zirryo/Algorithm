fun main() {
    val br = System.`in`.bufferedReader()
    val carMap = hashMapOf<String, Int>()
    val n = br.readLine().toInt()
    val order = IntArray(n) { 0 }
    var result = 0

    for (i in 1..n) {
        carMap[br.readLine()] = i
    }

    for (i in 0 until n) {
        val curOrder = carMap[br.readLine()]!!
        order[i] = curOrder
    }

    for (i in 0 until n-1) {
        for (j in i+1 until n) {
            if (order[i] > order[j]) {
                result++
                break // i번째로 나온 차량은 추월차량이라는 것이 확인되었으므로 내부 반복문 탈출
            }
        }
    }
    println(result)
}