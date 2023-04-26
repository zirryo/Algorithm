import kotlin.math.max

val br = System.`in`.bufferedReader()
var n = 0
fun main() {
    n = br.readLine().toInt()
    var answer = 0
    val likeInfo = Array(n*n) { List(5) {0} }
    val seat = Array(n) {Array(n) {0} }

    for (i in 0 until n*n) {
        likeInfo[i] = br.readLine().split(" ").map { it.toInt() }
    }

    seat[1][1] = likeInfo[0][0] // n은 3이상이므로 첫학생 자리는 항상 고정
    for(i in 1 until n*n) {
        collocate(seat, likeInfo[i])
    }
    for(i in 0 until n) {
        for(j in 0 until n) {
            var k = 0
            while(seat[i][j] != likeInfo[k][0]) k++
            answer += getLikes(seat, likeInfo[k], i, j)
        }
    }
    println(answer)
}
fun collocate(seat : Array<Array<Int>>, myInfo : List<Int>) {
    var i: Int
    var j: Int
    var c1 = condition1(seat, myInfo)
    var c2 : Pair<Int, Int> = Pair(-1, -1)
    if(c1.size != 1) { // 1
        c1 = condition2(seat, c1) // 2
        if(c1.size != 1) c2 = condition3(c1) // 3
    }
    if(c2.first == -1 && c2.second == -1) {
        i = c1[0].first
        j = c1[0].second
    } else {
        i = c2.first
        j = c2.second
    }
    seat[i][j] = myInfo[0]
}
fun condition1(seat : Array<Array<Int>>, myInfo : List<Int>) : ArrayList<Pair<Int, Int>> {
    var result = ArrayList<Pair<Int, Int>>()
    val cnt = Array(n) {Array(n) {0} }
    var maxFriends = 0
    for(i in 0 until n) {
        for(j in 0 until n) {
            var temp = 0
            if(seat[i][j] != 0) continue // 이미 자리가 있다면 스킵
            if(i-1 >= 0 && myInfo.contains(seat[i-1][j])) temp++
            if(j-1 >= 0 && myInfo.contains(seat[i][j-1])) temp++
            if(i+1 < n && myInfo.contains(seat[i+1][j])) temp++
            if(j+1 < n && myInfo.contains(seat[i][j+1])) temp++
            cnt[i][j] = temp
            maxFriends = max(maxFriends, temp)
        }
    }
    for(i in 0 until n) {
        cnt[i].forEachIndexed { j, c ->
            if(c == maxFriends && seat[i][j] == 0) result.add(Pair(i, j))
        }
    }
    return result
}
fun condition2(seat : Array<Array<Int>>, pair : ArrayList<Pair<Int, Int>>) : ArrayList<Pair<Int, Int>> {
    val cnt = Array(pair.size) {0}
    var maxEmpty = 0
    for (k in pair.indices) {
        var empty = 0
        val i = pair[k].first
        val j = pair[k].second
        if(i-1 >= 0 && seat[i-1][j] == 0) empty++
        if(j-1 >= 0 && seat[i][j-1] == 0) empty++
        if(i+1 < n && seat[i+1][j] == 0) empty++
        if(j+1 < n && seat[i][j+1] == 0) empty++
        cnt[k] = empty
        maxEmpty = max(maxEmpty, empty)
    }
    var pairSize = pair.size
    for (k in pairSize-1 downTo 0) {
        if(cnt[k] != maxEmpty) pair.removeAt(k)
    }
    return pair
}
fun condition3(pair : ArrayList<Pair<Int, Int>>) : Pair<Int, Int> {
    pair.sortedWith(compareBy(
        {it.first}, {it.second}
    ))
    return pair[0]
}
fun getLikes(seat: Array<Array<Int>>, myInfo: List<Int>, i: Int, j: Int) : Int {
    var likes = 0
    if(i-1 >= 0 && myInfo.contains(seat[i-1][j])) likes++
    if(j-1 >= 0 && myInfo.contains(seat[i][j-1])) likes++
    if(i+1 < n && myInfo.contains(seat[i+1][j])) likes++
    if(j+1 < n && myInfo.contains(seat[i][j+1])) likes++

    when (likes) {
        1 -> return 1
        2 -> return 10
        3 -> return 100
        4 -> return 1000
    }
    return 0
}