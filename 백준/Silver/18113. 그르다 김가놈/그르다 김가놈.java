import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] gimbaps = new int[N];
        ArrayList<Integer> trimmed = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());

            if (L >= 2 * K) {
                trimmed.add(L - 2 * K);
            } else if (L > K) {
                trimmed.add(L - K);
            }
        }

        if (trimmed.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int left = 1, right = Collections.max(trimmed);
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int length : trimmed) {
                count += length / mid;
            }

            if (count >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
