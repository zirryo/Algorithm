import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            values.add(A[i]);
        }

        int result = 0;

        for (int target : values) {
            int left = 0;
            int remove = 0;
            int L = 0;

            for (int right = 0; right < N; right++) {
                if (A[right] == target) {
                    L++;
                } else {
                    remove++;
                }

                while (remove > K) {
                    if (A[left] == target) {
                        L--;
                    } else {
                        remove--;
                    }
                    left++;
                }

                result = Math.max(result, L);
            }
        }

        System.out.println(result);
    }
}
