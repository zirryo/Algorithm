import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val paper = Array(100) { BooleanArray(100) } // 100x100 도화지
    val n = br.readLine().toInt()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                paper[i][j] = true
            }
        }
    }
    
    var area = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (paper[i][j]) area++
        }
    }

    println(area) 
}
