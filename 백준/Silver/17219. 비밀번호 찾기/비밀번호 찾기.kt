fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val token = br.readLine().split(" ").map { it.toInt() }
    val n = token[0]
    val m = token[1]
    val map = hashMapOf<String, String>()
    for (i in 0 until n) {
        val passcode = br.readLine().split(" ")
        map[passcode[0]] = passcode[1]
    }
    for (i in 0 until m) {
        val find = br.readLine()
        bw.write("${map[find]}\n")
    }
    bw.flush()
    bw.close()
}