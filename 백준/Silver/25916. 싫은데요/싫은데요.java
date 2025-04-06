import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] volume = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long sum = 0;
        long maxSum = 0;

        for (int right = 0; right < N; right++) {
            sum += volume[right];

            while (sum > M) {
                sum -= volume[left++];
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
