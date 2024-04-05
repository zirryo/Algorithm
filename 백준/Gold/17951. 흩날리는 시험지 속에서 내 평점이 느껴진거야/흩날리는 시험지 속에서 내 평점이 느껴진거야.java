import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total = 0;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            total += score[i];
        }
        System.out.println(binarySearch());
    }
    private static int binarySearch() {
        int l = 0;
        int r = total;

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;
            int group = 0;

            for (int i = 0; i < N; i++) {
                sum += score[i];
                if (sum >= mid) {
                    group++;
                    sum = 0;
                }
            }

            if (group >= M) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}