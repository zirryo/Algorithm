import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        int maxK = 0;
        while ((1 << (maxK + 1)) < N) {
            maxK++;
        }

        int[] original = new int[N];
        for (int i = 0; i < N; i++) original[i] = i + 1;

        for (int k1 = 1; k1 <= maxK; k1++) {
            int[] firstShuffled = shuffle(original, k1);

            for (int k2 = 1; k2 <= maxK; k2++) {
                int[] secondShuffled = shuffle(firstShuffled, k2);

                if (Arrays.equals(secondShuffled, target)) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }
    }

    static int[] shuffle(int[] cards, int K) {
        int[] current = cards.clone();

        int count = 1 << K;
        current = swap(current, N, count);

        for (int i = 2; i <= K + 1; i++) {
            int count2 = 1 << (K - i + 1);
            current = swap(current, count, count2);
            count = count2;
        }

        return current;
    }

    static int[] swap(int[] cards, int total, int count) {
        int[] next = new int[N];
        for (int i = 0; i < count; i++) {
            next[i] = cards[total - count + i];
        }

        for (int i = 0; i < total - count; i++) {
            next[count + i] = cards[i];
        }

        for (int i = total; i < N; i++) {
            next[i] = cards[i];
        }
        return next;
    }
}