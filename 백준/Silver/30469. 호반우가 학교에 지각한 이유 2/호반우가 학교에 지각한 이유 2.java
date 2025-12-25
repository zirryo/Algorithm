import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B;
    static boolean[] isPrime = new boolean[100];
    static boolean[][] possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        checkPrimes();
        
        if (!isPrime[A] || !isPrime[B]) {
            System.out.println(-1);
            return;
        }
        
        possible = new boolean[N][10];
        
        possible[N - 1][B % 10] = true;
        possible[N - 2][B / 10] = true;
        
        for (int i = N - 3; i >= 0; i--) {
            for (int cur = 0; cur <= 9; cur++) {
                for (int next = 0; next <= 9; next++) {
                    if (isPrime[cur * 10 + next] && possible[i + 1][next]) {
                        possible[i][cur] = true;
                        break;
                    }
                }
            }
        }
        
        int startSecondDigit = A % 10;
        if (!possible[1][startSecondDigit]) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A);

        int currentDigit = startSecondDigit;
        for (int i = 2; i < N; i++) {
            boolean moved = false;
            for (int next = 0; next <= 9; next++) {
                if (isPrime[currentDigit * 10 + next] && possible[i][next]) {
                    sb.append(next);
                    currentDigit = next;
                    moved = true;
                    break; 
                }
            }
        }

        System.out.println(sb);
    }

    static void checkPrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < 100; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 100; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}