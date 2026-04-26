import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long[] leftMax = new long[N];
        int minVal = A[0];
        leftMax[0] = Long.MIN_VALUE / 2;
        for (int j = 1; j < N; j++) {
            leftMax[j] = Math.max(leftMax[j - 1], (long)A[j] - minVal);
            minVal = Math.min(minVal, A[j]);
        }

        long[] rightMax = new long[N];
        int maxVal = A[N - 1];
        rightMax[N - 1] = Long.MIN_VALUE / 2;
        for (int k = N - 2; k >= 0; k--) {
            rightMax[k] = Math.max(rightMax[k + 1], (long)maxVal - A[k]);
            maxVal = Math.max(maxVal, A[k]);
        }

        long result = Long.MIN_VALUE;
        for (int j = 1; j < N - 2; j++) {
            result = Math.max(result, leftMax[j] + rightMax[j + 1]);
        }

        System.out.println(result);
    }
}