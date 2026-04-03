import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (N % 2 == 0) {
            // 짝수일 때는 {13, 31} 반복
            for (int i = 0; i < N / 2; i++) {
                sb.append("1331");
            }
        } else {
            // 홀수일 때는 31, 31, 37 (2+2-4 = 0)으로 3번의 소수 사용 후
            // 남은 N-3개를 13, 31 쌍으로 채움
            sb.append("313137");
            for (int i = 0; i < (N - 3) / 2; i++) {
                sb.append("1331");
            }
        }

        System.out.println(sb);
    }
}

/*
- 두 자릿수 소수 목록 ; {11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89}
- 11의 배수 판정법 : (홀수 번째 자릿수의 합) - (짝수 번째 자릿수의 합)이 0 혹은 11의 배수아다.
 */