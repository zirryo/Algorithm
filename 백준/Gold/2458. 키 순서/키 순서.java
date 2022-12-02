import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100000;
    static int s, e;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] student = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                student[i][j] = INF;
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            student[s][e] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    student[i][j] = Math.min(student[i][j], student[i][k] + student[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=1; j<=N; j++) {
                if(student[i][j] != INF || student[j][i] != INF) temp++;
            }
            if(temp == N-1) cnt++; // 모두와 연결되어 있으면 카운트
        }
        System.out.println(cnt);

    }

}