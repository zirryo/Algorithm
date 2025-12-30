import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double N = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());


        /* 기댓값 계산 방식 (기댓값의 선형성)
            - 전체 식사 횟수의 기댓값은 임의의 두 단원이 같은 조가 되어 식사를 할 확률의 합과 같음.
            - 임의의 두 단원 i, j 를 선택하는 방법의 수 N(N-1)/2
            - 단원 i 가 특정음을 선택했을 때, j가 같은 음을 선택할 확률 1/K
         */

        double answer = (N * (N - 1) / 2.0) / K;

        System.out.printf("%.10f\n", answer);
    }
}