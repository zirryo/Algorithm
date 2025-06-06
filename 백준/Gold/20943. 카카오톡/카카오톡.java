import java.io.*;
import java.util.*;

public class Main {
    static class Slope {
        int a, b;
        public Slope(long a, long b) {
            long gcd = gcd(Math.abs(a), Math.abs(b));
            a /= gcd;
            b /= gcd;

            if (b < 0 || (b == 0 && a < 0)) {
                a = -a;
                b = -b;
            }

            this.a = (int) a;
            this.b = (int) b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            return a == s.a && b == s.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        private long gcd(long a, long b) {
            while (b != 0) {
                long tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Slope, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            st.nextToken(); // c는 필요 X

            Slope slope = new Slope(a, b);
            map.put(slope, map.getOrDefault(slope, 0) + 1);
        }

        // 전체 가능한 쌍의 수
        long totalPairs = ((long) N * (N - 1)) / 2;

        // 평행한 직선 쌍 제거
        long parallelPairs = 0;
        for (int count : map.values()) {
            parallelPairs += ((long) count * (count - 1)) / 2;
        }

        System.out.println(totalPairs - parallelPairs);
    }
}
