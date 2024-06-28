import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long[] count = new long[10];
        long factor = 1;
        long lowerNum = 0, currNum = 0, higherNum = 0;

        while (N / factor > 0) {
            lowerNum = N - (N / factor) * factor;
            currNum = (N / factor) % 10;
            higherNum = N / (factor * 10);

            for (int i = 0; i < 10; i++) {
                count[i] += higherNum * factor;
            }
            for (int i = 0; i < currNum; i++) {
                count[i] += factor;
            }
            count[(int) currNum] += lowerNum + 1;

            count[0] -= factor;

            factor *= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i] + " ");
        }
        System.out.println(sb);
    }
}