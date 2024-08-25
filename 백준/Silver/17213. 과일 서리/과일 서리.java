import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 과일 종류
        int M = sc.nextInt();  // 총 과일의 개수

        /* 중복 조합
        - 항목을 선택할 때 같은 항목을 여러 번 선택하는 것이 허용됨.
        - 이항 계수 (조합)으로, "n + r - 1개의 항목 중에서 r개의 항목을 선택하는 경우의 수"
        - n + r - 1 = (M - N) + N - 1 = M - 1 => 반드시 종류당 하나를 훔치므로 미리 제외함.
        - r = N - 1 => 별과 막대로 치환해 보면 N - 1 개의 막대만 필요하므로 N이 아닌 N-1이 됨.

        **| |     (2개의 과일을 첫 번째 종류에 모두 배분)
        *|*|      (1개의 과일을 첫 번째, 1개의 과일을 두 번째 종류에 배분)
         |**|     (2개의 과일을 두 번째 종류에 모두 배분)
         |*|*     (1개의 과일을 두 번째, 1개의 과일을 세 번째 종류에 배분)
         | |**    (2개의 과일을 세 번째 종류에 모두 배분)
         */

        System.out.println(combination(M - 1, N - 1));
    }

    public static long combination(int n, int r) {
        if (r == 0 || n == r) return 1;

        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}

