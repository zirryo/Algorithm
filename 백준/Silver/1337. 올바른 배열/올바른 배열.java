import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        Arrays.sort(arr);

        int maxGroupSize = 1;

        for (int i = 0; i < N; i++) {
            int groupSize = 1;

            for (int j = i + 1; j < N; j++) {
                if (arr[j] - arr[i] <= 4) {
                    groupSize++;
                } else {
                    break;
                }
            }

            maxGroupSize = Math.max(maxGroupSize, groupSize);
        }

        int result = 5 - maxGroupSize;
        System.out.println(result);
    }
}
