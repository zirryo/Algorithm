import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int idx = 0;
            parent = new int[N*2];
            cnt = new int[N*2];
            for(int i=0; i<parent.length; i++) parent[i] = i;
            Arrays.fill(cnt, 1);
            HashMap<String, Integer> network = new HashMap<>();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if(!network.containsKey(f1)) {
                    network.put(f1, idx++);
                }

                if(!network.containsKey(f2)) {
                    network.put(f2, idx++);
                }

                int a = network.get(f1);
                int b = network.get(f2);

                union(a, b);
                sb.append(cnt[find(a)]).append("\n");

            }
        }
        System.out.println(sb);

    }
    
    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA < rootB) {
            parent[rootB] = rootA;
            cnt[rootA] += cnt[rootB];
            cnt[rootB] = 0;
        } else if (rootB < rootA) {
            parent[rootA] = rootB;
            cnt[rootB] += cnt[rootA];
            cnt[rootA] = 0;
        }
    }
}