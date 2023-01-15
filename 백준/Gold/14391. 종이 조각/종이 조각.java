import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        cutPaper();
        System.out.println(result);
    }

    private static void cutPaper() {
        // N*M 의 최댓값 == 16
        // 가로조각 0, 세로조각 1로 비트 마스킹
        // 브루트 포스로 0000 0000 0000 0000 ~ 1111 1111 1111 1111 까지 조합 탐색
        for(int k=0; k<(1<<N*M); k++) {
            int sum = 0; // 특정 조합일 때의 조각의 합

            // 가로 조각 탐색 (서 -> 동)
            for(int i=0; i<N; i++) {
                int slice = 0; // 한 조각의 값

                for(int j=0; j<M; j++) {
                    int cur = i * M + j;

                    if((k & (1<<cur)) == 0) { // 가로 조각
                        slice *= 10;
                        slice += map[i][j];
                    } else { // 가로 조각이 아님
                        sum += slice;
                        slice = 0;
                    }
                }
                sum += slice;
            }

            // 세로 조각 탐색 (북 -> 남)
            for(int i=0; i<M; i++) {
                int slice = 0; // 한 조각의 값

                for(int j=0; j<N; j++) {
                    int cur = j * M + i;

                    if((k & (1<<cur)) != 0) { // 세로 조각
                        slice *= 10;
                        slice += map[j][i];
                    } else { // 세로 조각이 아님
                        sum += slice;
                        slice = 0;
                    }
                }
                sum += slice;
            }
            result = Math.max(result, sum);
        }
    }
}