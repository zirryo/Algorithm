import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 0;
        int[] A = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            M += A[i];
            S[i] = M;
        }

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= M; i++) {
            if (M % i == 0) {
                divisors.add(i);
                if (i * i != M) divisors.add(M / i);
            }
        }

        int[] maxY = new int[N]; // 평화의 돌 없이 해결 가능한 cnt에 따른 가장 큰 Y

        for (int d : divisors) {
            int count = 0;
            for (int i = 0; i < N - 1; i++) {
                if (S[i] % d == 0) count++;
            }
            maxY[count] = Math.max(maxY[count], d);
        }

        // 평화의 돌 k개 사용 -> (N-1-k)개 이상의 경계가 d의 배수여야 함
        int[] result = new int[N];
        int currentMax = 0;

        // 경계가 많이 겹칠수록 Y가 작아짐 -> 역순으로 최댓값 갱신
        for (int c = N - 1; c >= 0; c--) {
            currentMax = Math.max(currentMax, maxY[c]);
            result[c] = currentMax;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= N - 1; k++) {
            sb.append(result[N - 1 - k]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}