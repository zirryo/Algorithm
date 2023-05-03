import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] cost;
    static final int INF = 200 * 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N+1][N+1];
        map = new int[N+1][N+1];
        for (int i=1; i<=N; i++) Arrays.fill(cost[i], INF);
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            cost[s][e] = v;
            cost[e][s] = v;
            map[s][e] = e;
            map[e][s] = s;
        }
        floydWarshall();
        printResult();
    }
    private static void floydWarshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        map[i][j] = map[i][k];
                        // 경유지를 거치는 게 더 빠르다면 가장 먼저 거쳐야 하는 집하장 정보를 갱신
                    }
                }
            }
        }
    }
    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) sb.append("- ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}