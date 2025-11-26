import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] days = new int[N];

        for (int i = 0; i < N; i++) {
            days[i] = Integer.parseInt(br.readLine().trim());
        }

        Set<Integer> set = new HashSet<>();
        for (int d : days) set.add(d);

        boolean[] used = new boolean[N]; 
        int answer = 0;

        for (int i = 1; i < N; i++) {
            if (used[i]) continue;

            int d = days[i] - 1; 
            answer++;

            long cur = 1;
            while (cur <= days[N - 1]) {
                if (set.contains((int) cur)) {
                    int idx = Arrays.binarySearch(days, (int) cur);
                    if (idx >= 0) used[idx] = true;
                }
                cur += d;
            }
        }

        System.out.println(answer);
    }
}
