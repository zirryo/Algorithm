import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = scores[N - 1 - i];

        int[] pref = new int[N + 2];
        int[] suff = new int[N + 2];
        Arrays.fill(pref, Integer.MIN_VALUE);
        Arrays.fill(suff, Integer.MIN_VALUE);

        for (int i = 1; i <= N; i++) {
            int val = arr[i - 1] + i;
            pref[i] = Math.max(pref[i - 1], val);
        }

        for (int i = N; i >= 1; i--) {
            int val = arr[i - 1] + (i - 1);
            suff[i] = Math.max(suff[i + 1], val);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int bestOther = Math.max(pref[i - 1], suff[i + 1]);
            if (arr[i - 1] + N >= bestOther) {
                count++;
            }
        }

        System.out.println(count);
    }
}
