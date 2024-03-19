import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] nick = new String[N];
        int[] cutOff = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nick[i] = st.nextToken();
            cutOff[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N-1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (cutOff[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            sb.append(nick[l]).append("\n");
        }


        System.out.println(sb);
    }
}