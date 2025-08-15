import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BitSet[] adj = new BitSet[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new BitSet(N + 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adj[l].set(r);
        }

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                BitSet common = (BitSet) adj[i].clone();
                common.and(adj[j]);
                int k = common.cardinality(); // 켜져 있는 비트 수 리턴
                if (k >= 2) {
                    answer += (long) k * (k - 1) / 2;
                }
            }
        }

        System.out.println(answer);
    }
}
