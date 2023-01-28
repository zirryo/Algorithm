import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] dist;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        getResult();

        System.out.println(sb);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[u][v] = -1;
            dist[v][u] = 1;
        }
    }

    private static void floydWarshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(dist[i][j] != 0) continue; // 선후관계를 알고있다면 스킵

                    if(dist[i][k] == -1 && dist[k][j] == -1) dist[i][j] = -1;
                    else if (dist[i][k] == 1 && dist[k][j] == 1) dist[i][j] = 1;
                }
            }
        }
    }

    private static void getResult() throws IOException{
        StringTokenizer st;

        int S = Integer.parseInt(br.readLine());

        while(S-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dist[a][b]).append("\n");
        }
    }

}