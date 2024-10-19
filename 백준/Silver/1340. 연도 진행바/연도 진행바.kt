import java.time.LocalDateTime
import java.time.ZoneOffset

fun main() {
    val input = readln().split(" ", ",")
    val month = input[0]
    val day = input[1].toInt()
    val year = input[3].toInt()
    val time = input[4].split(":").map { it.toInt() }
    val hour = time[0]
    val minute = time[1]

    val current = LocalDateTime.of(year, monthToNumber(month), day, hour, minute)
    val startOfYear = LocalDateTime.of(year, 1, 1, 0, 0)
    val endOfYear = LocalDateTime.of(year + 1, 1, 1, 0, 0)

    val totalMinutes = endOfYear.toEpochSecond(ZoneOffset.UTC) / 60 - startOfYear.toEpochSecond(ZoneOffset.UTC) / 60
    val elapsedMinutes = current.toEpochSecond(ZoneOffset.UTC) / 60 - startOfYear.toEpochSecond(ZoneOffset.UTC) / 60

    val progress = elapsedMinutes.toDouble() / totalMinutes.toDouble() * 100
    println(progress)
}

fun monthToNumber(month: String): Int {
    return when (month) {
        "January" -> 1
        "February" -> 2
        "March" -> 3
        "April" -> 4
        "May" -> 5
        "June" -> 6
        "July" -> 7
        "August" -> 8
        "September" -> 9
        "October" -> 10
        "November" -> 11
        "December" -> 12
        else -> -1
    }
}
