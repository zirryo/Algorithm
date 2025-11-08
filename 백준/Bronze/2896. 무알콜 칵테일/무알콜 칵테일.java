import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double I = Double.parseDouble(st.nextToken());
        double J = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());

        double t = Math.min(A / I, Math.min(B / J, C / K));

        double remainA = A - I * t;
        double remainB = B - J * t;
        double remainC = C - K * t;

        System.out.printf("%.6f %.6f %.6f%n", remainA, remainB, remainC);
    }
}
