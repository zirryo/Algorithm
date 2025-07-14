import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int left = 1;
        int right = N;
        for (int i = 0; i < N; i++) {
            A[i] = (i % 2 == 0) ? right-- : left++;
        }

        StringBuilder sb = new StringBuilder();

        for (int num : A) {
            sb.append(num + " ");
        }

        System.out.println(sb);
    }
}
