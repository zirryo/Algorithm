import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] birthCnt = new long[N + 1];
        birthCnt[1] = 1;

        for (int i = 2; i <= N; i++) {
            long curBirth = 0;

            for (int j = 1; j < i; j++) {
                if (isAlive(j, i)) {
                    curBirth += birthCnt[j];
                }
            }

            birthCnt[i] = curBirth;
        }

        long total = 0;
        for (int j = 1; j <= N; j++) {
            if (isAlive(j, N + 1)) {
                total += birthCnt[j];
            }
        }

        System.out.println(total);
    }

    static boolean isAlive(int birthYear, int curYear) {
        int age = curYear - birthYear;
        if (birthYear % 2 != 0) {
            return age <= 3;
        } else {
            return age <= 4;
        }
    }
}