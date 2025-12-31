import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double expectedValue = 0.0;

        for (int i = 1; i <= N; i++) {
            expectedValue += (double) N / i;
        }

        System.out.printf("%.10f\n", expectedValue);

        /* 기댓값 계산 방식 (기댓값의 선형성)
            - 기댓값 E[X] = N/N + N/(N-1) + ... + N/1
            - i-1 종류의 꽃을 모은 상태에서 아직 없는 i 번째 꽃이 나올 확률 N/(N-i+1)
         */

    }
}