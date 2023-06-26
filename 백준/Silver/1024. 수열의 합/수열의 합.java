import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int x = -1;
        int t = -1;
        int cnt = -1;

        // N = x + (x+1) + (x+2) + ... + (x+L-1)
        // N = Lx + (1 + 2 + 3 + ... + L-1)
        for (int i = L; i <= 100; i++) {
            int temp = N - (i * (i - 1) / 2);

            if ((temp % i) == 0 && (temp / i) >= 0) {
                x = temp / i;
                cnt = i;
                break;
            }
        }

        if (x == -1) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<cnt; i++) {
                sb.append(x + i).append(" ");
            }
            System.out.println(sb);
        }

    }
}