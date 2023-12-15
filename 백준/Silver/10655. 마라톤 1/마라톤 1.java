import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N+1];
        int[] y = new int[N+1];
        int[] dist = new int[N+1];
        int totalDist = 0;
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            if (i >= 2) {
                dist[i] = Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
                totalDist += dist[i];
            }
        }
        int shortcut = -totalDist; // 체크포인트를 건너뛰어서 줄일 수 있는 최대 거리
        for (int i = 2; i < N; i++) {
            int temp = dist[i] + dist[i+1] -
                    (Math.abs(x[i+1] - x[i-1]) + Math.abs(y[i+1] - y[i-1]));
            shortcut = Math.max(shortcut, temp);
        }
        System.out.println(totalDist - shortcut);
    }
}