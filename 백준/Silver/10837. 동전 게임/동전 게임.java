import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        for (int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            sb.append(isValid(M, N)).append("\n");
        }

        System.out.println(sb);
    }
    private static int isValid(int m, int n) {
        if (m == n) return 1;

        int diff = Math.abs(m - n);
        int temp = K - Math.max(m, n);
        if (m < n) {
            if (diff - temp <= 1) return 1;
        } else {
            if (diff - temp <= 2) return 1; // 항상 영희가 먼저 플레이하므로
        }
        return 0;
    }
}