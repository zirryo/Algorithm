import java.util.*;

public class Main {

    static int N;
    static int count = 0;
    static int[] digits = {0, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(count);
    }

    static void dfs(int depth, int sum, int num) {
        if (depth == N) {
            if (sum % 3 == 0) {
                count++;
            }
            return;
        }

        for (int d : digits) {
            if (depth == 0 && d == 0) continue;
            dfs(depth + 1, sum + d, num * 10 + d);
        }
    }
}
