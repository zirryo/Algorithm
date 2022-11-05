import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int initial = 101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] friends = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i != j) friends[i][j] = initial;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    // 경유지를 방문하는 것이 더 효율적인 경우 값을 갱신
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }

        int kevinBacon = Integer.MAX_VALUE;
        int idx = 0;

        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=1; j<=N; j++) {
                temp += friends[i][j];
            }

            if(temp < kevinBacon) {
                kevinBacon = temp;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}