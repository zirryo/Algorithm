import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[50001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int c = Integer.parseInt(st.nextToken());
            cnt[c]++;
        }

        int result = 0;
        for (int i=50000; i>=1; i--) {
            if (result < cnt[i]) result = cnt[i];
        }

        System.out.println(result);
    }
}
