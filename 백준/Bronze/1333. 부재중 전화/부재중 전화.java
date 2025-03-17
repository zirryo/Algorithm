import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int totalTime = (N - 1) * (L + 5) + L;

        List<int[]> songIntervals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = i * (L + 5);
            int end = start + L;
            songIntervals.add(new int[]{start, end});
        }

        int ringTime = 0;
        while (ringTime <= totalTime) {
            boolean isPlaying = false;
            for (int[] interval : songIntervals) {
                if (ringTime >= interval[0] && ringTime < interval[1]) {
                    isPlaying = true;
                    break;
                }
            }

            if (!isPlaying) {
                System.out.println(ringTime);
                return;
            }

            ringTime += D;
        }

        System.out.println(ringTime);
    }
}
