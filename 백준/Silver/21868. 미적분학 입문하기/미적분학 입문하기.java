import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long e1 = Long.parseLong(st.nextToken());
        long e2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long x0 = Long.parseLong(br.readLine());

        long L = a * x0 + b;
        System.out.println(L);

        if (a == 0) { // 상수함수 -> 최댓값 없음
            System.out.println("0 0");
        } else { // 일차함수
            long absA = Math.abs(a);
            long d1 = e1;
            long d2 = e2 * absA;

            if (d2 > 100_000_000L || d1 > 100_000_000L) {
                System.out.println("0 0");
            } else {
                System.out.println(d1 + " " + d2);
            }
        }
    }
}