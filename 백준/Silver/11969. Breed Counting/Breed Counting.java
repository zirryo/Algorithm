import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][4];

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = arr[i-1][j];
            }
            arr[i][x] = arr[i-1][x] + 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 3; j++) {
                sb.append(arr[b][j] - arr[a-1][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}