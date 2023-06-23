import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0L;
        StringTokenizer st = new StringTokenizer(br.readLine());
        long left = Long.parseLong(st.nextToken());
        long right = Long.parseLong(st.nextToken());

        if (N > 1) {
            for (int i=1; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                if (y < right) continue;

                if (x > right) {
                    result += right - left;
                    left = x;
                }
                right = y;
            }
        }
        result += (right - left);
        System.out.println(result);
    }
}