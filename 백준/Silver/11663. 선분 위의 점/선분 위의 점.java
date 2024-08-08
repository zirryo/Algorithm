import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] points;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());
        N = Integer.parseInt(nm.nextToken());
        M = Integer.parseInt(nm.nextToken());

        points = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(line.nextToken());
            int r = Integer.parseInt(line.nextToken());

            int count = upperBound(r) - lowerBound(l);
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    static int upperBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (points[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (points[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
