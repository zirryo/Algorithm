fun main() {
    val pattern = readln()
    val n = readln().toInt()
    var count = 0

    repeat(n) {
        val ring = readln()
        val doubledRing = ring + ring

        if (doubledRing.contains(pattern)) {
            count++
        }
    }

    println(count)
}
