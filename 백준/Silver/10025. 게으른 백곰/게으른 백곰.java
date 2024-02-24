import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) * 2 + 1;
        int[] ice = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] = g;
        }

        int sum = 0;
        int result = 0;

        for (int i = 0; i <= 1000000; i++) {
            if (i - K >= 0) sum -= ice[i - K];
            sum += ice[i];
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
