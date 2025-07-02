import java.util.*;
import java.io.*;

public class Main {

    static int N, shootCnt;
    static long minScore;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        shootCnt = Integer.parseInt(st.nextToken());
        minScore = Long.parseLong(st.nextToken());

        targets = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(targets);

        int left = 0;
        int right = 100_000;
        int answer = 100_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAchieve(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canAchieve(int skill) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        long total = 0;
        int cnt = 0;

        while (cnt < shootCnt) {
            while (idx < N && targets[idx] <= skill) {
                pq.offer(targets[idx]);
                idx++;
            }

            if (pq.isEmpty()) return false;

            int score = pq.peek();
            total += score;
            skill += score;
            cnt++;

            if (total >= minScore) return true;
        }

        return total >= minScore;
    }
}
