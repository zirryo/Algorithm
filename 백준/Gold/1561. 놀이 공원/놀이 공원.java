import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] rideTime = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rideTime[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        long left = 0, right = 2000000000L * 30;
        long resultTime = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = M;
            for (int time : rideTime) {
                count += mid / time;
                if (count >= N) break;
            }

            if (count >= N) {
                resultTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long prevCount = M;
        for (int time : rideTime) {
            prevCount += (resultTime - 1) / time;
        }

        for (int i = 0; i < M; i++) {
            if (resultTime % rideTime[i] == 0) {
                prevCount++;
                if (prevCount == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
