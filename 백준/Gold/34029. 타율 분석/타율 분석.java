import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextDouble();
        int B = sc.nextInt();

        double[][] C = new double[B+1][B+1];
        for (int i = 0; i <= B; i++) {
            C[i][0] = C[i][i] = 1.0;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        for (int c = 0; c <= B; c++) {
            double cumulative = 0.0;
            for (int k = 0; k <= c; k++) {
                cumulative += C[B][k] * Math.pow(A, k) * Math.pow(1 - A, B - k);
            }
            if (cumulative >= 0.05) {
                System.out.println(c);
                return;
            }
        }
    }
}
