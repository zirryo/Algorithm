fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val cardCount = mutableMapOf<Long, Int>()

    repeat(n) {
        val card = br.readLine().toLong()
        cardCount[card] = cardCount.getOrDefault(card, 0) + 1
    }

    var result = Long.MAX_VALUE
    var maxCount = 0

    for ((card, count) in cardCount) {
        if (count > maxCount || (count == maxCount && card < result)) {
            result = card
            maxCount = count
        }
    }

    println(result)
}