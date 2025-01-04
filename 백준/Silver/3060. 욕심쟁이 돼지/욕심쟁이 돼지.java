import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long total = Long.parseLong(br.readLine());
            long perDay = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                perDay += Long.parseLong(st.nextToken());
            }

            int days = 1;
            while (total >= perDay) {
                perDay *= 4;
                days++;
            }

            sb.append(days).append("\n");
        }
        System.out.println(sb);
    }
}
