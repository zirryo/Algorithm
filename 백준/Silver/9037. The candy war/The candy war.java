import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                if ((a[i] & 1) == 1) a[i]++;
            }

            if (allEqual(a)) {
                sb.append(0).append('\n');
                continue;
            }

            int cycles = 0;

            while (true) {
                int[] next = new int[N];
                for (int i = 0; i < N; i++) {
                    int left = (i - 1 + N) % N;
                    next[i] = a[i] / 2 + a[left] / 2;
                }

                for (int i = 0; i < N; i++) {
                    if ((next[i] & 1) == 1) next[i]++;
                }

                cycles++;
                a = next;

                if (allEqual(a)) break;
            }

            sb.append(cycles).append('\n');
        }

        System.out.print(sb);
    }

    static boolean allEqual(int[] arr) {
        int v = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != v) return false;
        }
        return true;
    }
}
