import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 4000001;
    static int result = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] road = new int[V+1][V+1];

        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                road[i][j] = INF;
            }
        }

        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a][b] = c;
        }

        for(int k=1; k<=V; k++) {
            for(int i=1; i<=V; i++) {
                for(int j=1; j<=V; j++) {
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }

        for(int i=1; i<=V; i++) {
            result = Math.min(result, road[i][i]);
        }

        if(result == INF) System.out.println("-1");
        else System.out.println(result);
    }
}