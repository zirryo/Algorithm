import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long X = scanner.nextLong();
        long Y = scanner.nextLong();
        long Z = scanner.nextLong();
        long result = 0L;

        for(int i = 0; i < 3; i++) {
            long temp = Math.min(A, X);
            A -= temp;
            X -= temp;
            result += temp;

            temp = Math.min(B, Y);
            B -= temp;
            Y -= temp;
            result += temp;

            temp = Math.min(C, Z);
            C -= temp;
            Z -= temp;
            result += temp;

            long tempX = X;
            long tempY = Y;
            long tempZ = Z;

            Y = tempX / 3;
            Z = tempY / 3;
            X = tempZ / 3;
        }

        System.out.println(result);
    }
}
