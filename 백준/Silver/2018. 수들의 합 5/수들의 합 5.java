import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int k = 1; k * (k - 1) / 2 < N; k++) {
            int temp = N - k * (k - 1) / 2;
            if (temp > 0 && temp % k == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
