import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] cost;
    static int[] min;
    static int N, M, K;
    static int INF = 10_000_000;
    static String not = "Oh no";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        cost = new int[N+1];
        min = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            parent[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
            min[i] = INF;
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a < b) union(a, b);
            else union(b, a);
        }

        for(int i=1; i<=N; i++) {
            int root = find(i);
            min[root] = Math.min(min[root], cost[i]);
        }

        int result = 0;

        for(int i=1; i<=N; i++) {
            result += min[i] != INF ? min[i] : 0;
        }

        if(result > K) System.out.println(not);
        else System.out.println(result);
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootB] = rootA;
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}