import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lines = Math.min(N, M) / 2;
        while (R-- > 0) {
            for (int k = 0; k < lines; k++) {
                int temp = arr[k][k];
                for (int i = k + 1; i < M - k; i++) {
                    arr[k][i-1] = arr[k][i];
                }
                for (int j = k + 1; j < N - k; j++) {
                    arr[j-1][M-1-k] = arr[j][M-1-k];
                }
                for (int i = M - 1 - k; i > k; i--) {
                    arr[N-1-k][i] = arr[N-1-k][i-1];
                }
                for (int j = N - 1 - k; j > k; j--) {
                    arr[j][k] = arr[j-1][k];
                }

                arr[k+1][k] = temp;
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}