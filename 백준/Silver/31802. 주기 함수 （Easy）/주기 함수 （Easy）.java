import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        long[] pref = new long[p + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            long val = Long.parseLong(st.nextToken());
            pref[i] = pref[i - 1] + val;
        }

        long onePeriodSum = pref[p];

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 적분의 선형성 : integral(a, b) = integral(0, b) - integral(0, a)
        System.out.println(integral(b, p, pref, onePeriodSum) - integral(a, p, pref, onePeriodSum));
    }

    static long integral(long x, int p, long[] pref, long totalSum) {
        long periodCnt = x / p;
        int remain = (int)(x % p);

        // % 연산 음수 보정
        if (remain < 0) {
            periodCnt -= 1;
            remain += p;
        }

        return (periodCnt * totalSum) + pref[remain];
    }
}