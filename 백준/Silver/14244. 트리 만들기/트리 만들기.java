import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if (M == 2) {
            for (int i = 1; i < N; i++) {
                sb.append(String.format("%d %d\n", i-1, i));
            }
        } else {
            for (int i = 1; i < N; i++) {
                if (M > 0) {
                    sb.append(String.format("0 %d\n", i));
                    M--;
                } else {
                    sb.append(String.format("%d %d\n", i-1, i));
                }
            }
        }

        System.out.println(sb);
    }
}
