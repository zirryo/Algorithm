import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        while (T-- > 0) {
            long N = sc.nextLong();
            sb.append(solve(N)).append("\n");
        }

        System.out.println(sb);
    }

    static int solve(long N) {
        if (N == 1) return 1;
        int answer = 0;

        for (int d = 9; d >= 2; d--) {
            while (N % d == 0) {
                N /= d;
                answer++;
            }
        }

        if (N != 1) return -1;

        return answer;
    }
}
