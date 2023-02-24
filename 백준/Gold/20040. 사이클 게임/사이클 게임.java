import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0, result = 0;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int i=0; i<N; i++) parent[i] = i;

        while(true) {
            cnt++;
            if(cnt > M) {
                result = 0;
                break;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a, b)) {
                result = cnt;
                break;
            }
        }
        System.out.println(result);
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;
        parent[b] = a;
        return true;
    }
}