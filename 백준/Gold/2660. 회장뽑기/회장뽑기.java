import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int initial = 51; // 최댓값으로 초기화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i == j) map[i][j] = 0;
                else map[i][j] = initial;
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(s == -1 && e == -1) break;

            map[s][e] = 1;
            map[e][s] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]); // 경유지를 방문하는 것이 더 비용이 적으면 경로 갱신
                }
            }
        }

        int min = initial; // 회장 후보의 점수 찾기
        int[] score = new int[N+1];

        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=1; j<=N; j++) {
                temp = Math.max(temp, map[i][j]);
            }
            score[i] = temp;
            min = Math.min(min, temp);
        }

        int cnt = 0;

        for(int i=1; i<=N; i++) {
            if(score[i] == min) {
                cnt++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(min + " " + cnt);
        System.out.println(sb);
    }

}