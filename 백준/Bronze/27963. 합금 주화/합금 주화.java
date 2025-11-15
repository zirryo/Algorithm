import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double d1 = sc.nextDouble();
        double d2 = sc.nextDouble();
        double chi = sc.nextDouble();
        double dh = Math.max(d1, d2);
        double dl = Math.min(d1, d2);
        double f = chi / 100.0;
        double rho = 1.0 / (f / dh + (1.0 - f) / dl);
        System.out.printf(Locale.US, "%.10f%n", rho);
    }
}
