import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] p = new double[10];
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            if (line == null) line = "0";
            p[i] = Double.parseDouble(line.trim());
        }

        Arrays.sort(p); 
        double prod = 1.0;
        for (int i = 1; i < 10; i++) {
            prod *= p[i];
        }

        double factorial9 = 362880.0;
        double ans = prod / factorial9 * 1e9;

        System.out.printf(Locale.US, "%.10f\n", ans);
    }
}
