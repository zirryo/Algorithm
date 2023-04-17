import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        dp = new int[N+1][2]; // 0-얼리어답터, 1-일반인
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    private static void dfs(int x) {
        visited[x] = true;
        dp[x][0] = 1;
        for(int y : tree[x]) {
            if(visited[y]) continue;
            dfs(y);
            dp[x][1] += dp[y][0]; // 자신이 얼리어답터가 아니면, 연결된 모두가 얼리어답터여야함.
            dp[x][0] += Math.min(dp[y][0], dp[y][1]); // 자신이 얼리어답터라면, 연결된 사람은 얼리어답터 혹은 일반인
        }
    }
    // dp[x][0] : x는 얼리어답터일 때. 최소 얼리어답터의 수
    // dp[x][1] : x는 얼리어답터 아닐 때. 최소 얼리어답터의 수
}