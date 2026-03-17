import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long totalSum = 0;
        long minVal = 1_000_000_000L;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                long x = Long.parseLong(st.nextToken());
                minVal = Math.min(x, minVal);
                totalSum += x;
            }
        }

        System.out.println(totalSum - minVal);
    }
}