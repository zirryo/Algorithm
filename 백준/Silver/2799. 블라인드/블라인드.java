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
        String[] window = new String[5 * N + 1];
        for (int i = 0; i < window.length; i++) {
            window[i] = br.readLine();
        }

        int[] result = new int[5];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int blind = 0;
                for (int k = 1; k <= 4; k++) {
                    if (window[5 * i + k].charAt(5 * j + 1) == '*') {
                        blind++;
                    } else break;
                }
                result[blind]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}