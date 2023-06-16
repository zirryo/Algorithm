import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = 12 * 1_000_000;
    static final int NOWAY = 10 * 1_000_000 + 1; // 사이클이 완성되지 않는 경우 구분
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][1<<N]; // int[현위치][방문기록(비트마스크)]
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        int result = dfs(0, 1); // 시작점은 0번째 도시, 이진수 1로 해당 도시 방문 체크
        System.out.println(result);
    }

    private static int dfs(int cur, int visit) {
        if(visit == (1 << N) - 1) { // 모든 도시 방문 완료한 경우
            // 시작도시(0)으로 돌아갈 수 있다면 해당 값 리턴, 돌아갈 수 없다면 NOWAY 리턴하여 방문하지 않은 곳과 구분
            return dp[cur][visit] = cost[cur][0] != 0 ? cost[cur][0] : NOWAY;
        }

        if(dp[cur][visit] != INF) return dp[cur][visit]; // 이미 값을 안다면 결과 리턴

        for(int i = 0; i < N; i++) {
            if(cost[cur][i] == 0 || (visit & (1 << i)) != 0) {
                continue; // 갈 수 없는 곳이거나 이미 방문한 곳일 경우 스킵
            }

            int next = visit | (1 << i); // 다음 방문할 곳(i번째 도시)을 비트마크킹 연산으로 표시
            dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, next) + cost[cur][i]);
        }

        return dp[cur][visit];
    }

}

/* 외판원 순회 (TSP:Traveling Salesperson Problem)
    도시들이 있고 특정 도시에서 도시로 이동할 때 드는 비용이 주어졌을 때,
    불특정한 도시에서 출발해서 모든 도시를 돌고 다시 출발 도시로 돌아왔을 때 드는 최소 비용을 구하는 문제

    - N이 16 이하인 경우 dp 와 Bitmask 를 활용
    - dp : 특정 도시를 방문한 상태일 때의 최소 비용 저장
    - bitmask : 특정 도시 방문 여부 확인
    - 사이클이 발생하기 때문에 출발 도시는 임의로 지정 가능
 */