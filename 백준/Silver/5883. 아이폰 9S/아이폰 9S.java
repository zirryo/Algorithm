import java.io.*;
import java.util.*;

public class Main {
    static int getMaxStreak(List<Integer> list) {
        int maxLen = 0;
        int currentLen = 0;
        int prev = -1;

        for (int val : list) {
            if (val == prev) {
                currentLen++;
            } else {
                currentLen = 1;
                prev = val;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] B = new int[N];
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
            unique.add(B[i]);
        }

        int maxResult = 0;

        for (int remove : unique) {
            List<Integer> filtered = new ArrayList<>();
            for (int val : B) {
                if (val != remove) {
                    filtered.add(val);
                }
            }
            maxResult = Math.max(maxResult, getMaxStreak(filtered));
        }

        System.out.println(maxResult);
    }
}
