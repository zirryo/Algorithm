import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if(k == 1) union(i, j); // 길이 있다면 연결
            }
        }

        st = new StringTokenizer(br.readLine()); // 여행지 정보
        int start = Integer.parseInt(st.nextToken()); // 출발점
        int startRoot = find(start);

        for(int i=1; i<M; i++) {
            int next = Integer.parseInt(st.nextToken()); // 배열은 0부터 여행지는 1부터 시작하므로 -1
            int nextRoot = find(next);

            if(startRoot != nextRoot) {
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int find(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parent[aRoot] = b;
        else return;
    }

}