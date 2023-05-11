import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N-2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a < b) union(a, b);
            else union(b, a);
        }
        
        int parent1 = find(parent[1]);
        for (int i=2; i<=N; i++) {
            if (parent1 != find(parent[i])) {
                System.out.println(1 + " " + i);
                break;
            }
        }
    }
    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}