fun main() {
    val scores = Array(8) { Pair(readln().toInt(), it + 1) }
    val sortedScores = scores.sortedByDescending { it.first }
    val topScores = sortedScores.take(5)
    val sum = topScores.sumOf { it.first }
    val indices = topScores.map { it.second }.sorted()
    
    println(sum)
    println(indices.joinToString(" "))
}
