import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        long m = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            m += a[i];
        }

        long avg = m / n;
        int remain = (int) (m % n);

        Arrays.sort(a);

        long moveCount = 0;

        for (int i = 0; i < n - remain; i++) {
            if (a[i] > avg) {
                moveCount += (a[i] - avg);
            }
        }

        for (int i = n - remain; i < n; i++) {
            if (a[i] > avg + 1) {
                moveCount += (a[i] - (avg + 1));
            }
        }

        System.out.println(moveCount);
    }
}