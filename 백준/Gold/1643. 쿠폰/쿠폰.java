import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            if (N == 1) {
                System.out.println(1);
                continue;
            }

            long num = 0;
            long den = 1;

            for (int i = 1; i <= N; i++) {
                num = num * i + den * N;
                den = den * i;
                long common = gcd(num, den);
                num /= common;
                den /= common;
            }

            long integerPart = num / den;
            long rem = num % den;

            if (rem == 0) {
                System.out.println(integerPart);
            } else {
                String sInt = String.valueOf(integerPart);
                String sDen = String.valueOf(den);
                int spaceLen = sInt.length() + 1;
                int barLen = sDen.length();

                for (int i = 0; i < spaceLen; i++) System.out.print(" ");
                System.out.println(rem);

                System.out.print(sInt + " ");
                for (int i = 0; i < barLen; i++) System.out.print("-");
                System.out.println();

                for (int i = 0; i < spaceLen; i++) System.out.print(" ");
                System.out.println(den);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}