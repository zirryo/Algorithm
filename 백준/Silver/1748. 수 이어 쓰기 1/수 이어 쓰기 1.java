import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long length = 0L;
        int start = 1;
        int digit = 1;

        while (start <= N) {
            int end = Math.min(N, start * 10 - 1);
            length += (long)(end - start + 1) * digit;
            start *= 10;
            digit++;
        }

        System.out.println(length);
    }
}
