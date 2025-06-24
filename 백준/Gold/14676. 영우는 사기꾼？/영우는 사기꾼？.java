import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Integer>[] graph;
    static int[] inDegree, builtCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        inDegree = new int[N + 1];
        builtCount = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph[X].add(Y);
            inDegree[Y]++;
        }

        boolean liar = false;
        for (int i = 0; i < K; i++) {
            if (liar) continue;

            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (cmd == 1) { // 건설
                if (inDegree[a] > 0) liar = true;
                else {
                    builtCount[a]++;
                    if (builtCount[a] == 1) {
                        for (int next : graph[a]) {
                            inDegree[next]--;
                        }
                    }
                }
            } else { // 파괴
                if (builtCount[a] == 0) liar = true;
                else {
                    builtCount[a]--;
                    if (builtCount[a] == 0) {
                        for (int next : graph[a]) {
                            inDegree[next]++;
                        }
                    }
                }
            }
        }

        System.out.println(liar ? "Lier!" : "King-God-Emperor");
    }
}
