import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double x, y, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double lo = 0;
        double hi = Math.min(x ,y);
        double result = 0;

        while (hi - lo > 1e-6) {
            double mid = (lo + hi) / 2;

            if (isValid(mid)) {
                result = mid;
                lo = mid;
            } else {
                hi = mid;
            }
        }

        System.out.printf("%.3f", result);
    }
    private static boolean isValid(double mid) {
        double h1 = Math.sqrt(x * x - mid * mid);
        double h2 = Math.sqrt(y * y - mid * mid);
        return ((h1 * h2) / (h1 + h2)) >= c;
    }
}