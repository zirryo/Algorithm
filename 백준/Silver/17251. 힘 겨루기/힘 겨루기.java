import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] fromLeft = new int[N + 1];
        int[] fromRight = new int[N + 2];

        fromLeft[1] = a[1];
        for (int i = 2; i <= N; i++) fromLeft[i] = Math.max(fromLeft[i - 1], a[i]);

        fromRight[N] = a[N];
        for (int i = N - 1; i >= 1; i--) fromRight[i] = Math.max(fromRight[i + 1], a[i]);

        long leftWin = 0, rightWin = 0;
        for (int i = 1; i <= N - 1; i++) {
            int L = fromLeft[i];
            int R = fromRight[i + 1];

            if (L > R) leftWin++;
            else if (R > L) rightWin++;
        }

        if (leftWin > rightWin) System.out.println("R");
        else if (rightWin > leftWin) System.out.println("B");
        else System.out.println("X");
    }
}
