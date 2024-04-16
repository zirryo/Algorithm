import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 책
            int M = Integer.parseInt(st.nextToken()); // 학생
            int[][] arr = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i][0] = a;
                arr[i][1] = b;
            }
            Arrays.sort(arr, ((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

            int cnt = 0;
            boolean[] visited = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                int l = arr[i][0];
                int r = arr[i][1];

                for (int j=l; j<=r; j++) {
                    if (!visited[j]) {
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}