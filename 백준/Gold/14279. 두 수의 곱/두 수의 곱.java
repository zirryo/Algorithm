import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = Long.MAX_VALUE;

        for (long A = 1; A <= 2000000; A++) {
            /*
            - A의 값을 a 의 최댓값인 1000000 의 2배로 여유있게 설정
            - B의 후보들: 1(최솟값), b(두번째 항을 0으로 만듦), c/A의 근처의 정수(세번째 항을 0으로 만듦)
            */

            long[] bArr = {1, b, c / A, c / A + 1};

            for (long B : bArr) {
                if (B <= 0) continue;

                long C = A * B;
                long currentDiff = Math.abs(A - a) + Math.abs(B - b) + Math.abs(C - c);

                if (currentDiff < result) {
                    result = currentDiff;
                }
            }

            // (A-a) 값이 현재의 최솟값 보다 크더라도 A가 a 보다 작은 경우 추가 탐색
            if (A > a && (A - a) > result) break;
        }

        System.out.println(result);
    }
}