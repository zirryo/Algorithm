import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] A = new int[K + 1];
        int[] B = new int[K + 1];

        A[0] = 1;
        B[0] = 0;

        for (int i = 1; i <= K; i++) {
            A[i] = B[i - 1];  // 이전 B의 개수가 현재 A로
            B[i] = A[i - 1] + B[i - 1];  // 이전 A와 B의 개수가 새로운 B로 합쳐짐
        }

        System.out.println(A[K] + " " + B[K]);
    }
}
