import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long count = 0;

        while (true) {
            if (N % 5 == 0) {
                count += (N / 5);
                System.out.println(count);
                break;
            }
            N -= 3;
            count++;

            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
