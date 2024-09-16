import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        /* [유니온 파인드의 시간 복잡도]
        경로 압축과 랭크 기반 합치기를 사용하면 거의 상수 시간에 가까운 O(α(N))
        α(N) : 매우 느리게 증가하는 역아커만 함수
        아커만 함수 : 두 자연수 𝑚과 𝑛을 받아서 매우 빠르게 커지는 결과를 반환하는 함수
        
        유니온 파인드 알고리즘에서 경로 압축과 랭크 기반 합치기를 사용하면 각 연산이 거의 상수 시간에 수행됨.
        */

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append(String.format("Scenario %d:\n", t));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            rank = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int Q = Integer.parseInt(br.readLine());
            for (int i = 0; i < Q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (find(a) == find(b)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
