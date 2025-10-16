import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.close();

        long answer;
        if (N == 3) {
            if (R == 2 && C == 2) answer = 1;
            else answer = 4;
        } else { // N >= 4
            answer = (N * N + 1) / 2;

            if (N % 2 == 1 && ((R + C) % 2 == 1)) {
                answer--;
            }
        }

        System.out.println(answer);
    }
}
