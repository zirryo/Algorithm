import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] applePie = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            applePie[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n + k];
        for (int i = 1; i < n + k; i++) {
            sum[i] = sum[i - 1] + (i <= n ? applePie[i] : applePie[i - n]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i+k] - sum[i] > result) {
                result = sum[i+k] - sum[i];
            }
        }

        System.out.println(result);
    }
}