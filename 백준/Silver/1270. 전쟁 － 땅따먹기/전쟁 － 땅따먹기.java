import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T;
        long ans;
        Map<Long, Integer> map;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            ans = -1;
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            for (int j = 0; j < T; j++) {
                long num = Long.parseLong(st.nextToken());
                int cnt = map.getOrDefault(num, 0) + 1;
                if (cnt > (T / 2)) {
                    ans = num;
                    break;
                }
                map.put(num, cnt);
            }

            if (ans != -1) sb.append(ans).append("\n");
            else sb.append("SYJKGW\n");
        }

        System.out.println(sb);
    }
}