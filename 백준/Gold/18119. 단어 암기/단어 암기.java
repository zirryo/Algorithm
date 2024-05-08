import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                arr[i] |= 1 << (c - 'a');
            }
        }

        int know = (1 << 26) - 1; // 처음에는 모든 알파벳을 알고 있음.

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = st.nextToken().charAt(0) - 'a';

            if (x == 1) {
                know &= ~(1 << y);
            } else {
                know |= (1 << y);
            }
            
            int cnt = 0;
            for (int z : arr) {
                if ((know & z) == z) cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}