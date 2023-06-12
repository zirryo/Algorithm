import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long start = 0;
    static Set<Long> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(st.nextToken());
            set.add(k);
        }

        for (long num : set) {
            if (set.contains(num * 3)) continue;
            if (set.contains(num / 2)) {
                if (num % 2 == 0) continue;
                start = num;
                break;
            }
            start = num;
            break;
        }

        List<Long> result = new ArrayList<>();
        result.add(start);
        for (int i=0; i<N-1; i++) {
            long cur = result.get(i);
            if (cur % 3 == 0 && set.contains(cur / 3)) {
                result.add(cur / 3);
            } else result.add(cur * 2);
        }

        StringBuilder sb = new StringBuilder();
        for (long x : result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}