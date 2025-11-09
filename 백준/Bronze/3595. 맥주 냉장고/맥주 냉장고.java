import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int A = 1, B = 1, C = n;
        int minSurface = Integer.MAX_VALUE;

        for (int a = 1; a * a * a <= n; a++) {
            if (n % a != 0) continue;
            int remain1 = n / a;

            for (int b = a; b * b <= remain1; b++) {
                if (remain1 % b != 0) continue;
                int c = remain1 / b;

                int surface = 2 * (a*b + b*c + c*a);
                if (surface < minSurface) {
                    minSurface = surface;
                    A = a;
                    B = b;
                    C = c;
                }
            }
        }

        System.out.println(A + " " + B + " " + C);
    }
}
