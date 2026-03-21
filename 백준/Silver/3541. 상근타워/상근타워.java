import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long minFloor = Long.MAX_VALUE;

        /* 수식 설계
        - 올라가는 버튼을 누르는 횟수 : x, 내려가는 버튼을 누르는 횟수 : y
        - 조작 횟수 : x + y = n, y = n - x
        - 최종 도착 층 : f(x) = (x * u) - (y * d) = x * (u + d) - n * d
        - 조건 : x >= 0, y >= 0, f(x) > 0
        - x * (u + d) > n * d, x > (n * d) / (u + d)
         */

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long u = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long x = (n * d) / (u + d) + 1;

            if (x <= n) {
                long height = x * u - (n - x) * d;
                if (height > 0) {
                    minFloor = Math.min(minFloor, height);
                }
            }
        }

        System.out.println(minFloor);
    }
}