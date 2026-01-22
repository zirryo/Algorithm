import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        double xS = sc.nextDouble();
        double yS = sc.nextDouble();

        double[][] p = new double[3][2];
        for (int i = 0; i < 3; i++) {
            p[i][0] = sc.nextDouble();
            p[i][1] = sc.nextDouble();
        }

        double minTotalDist = Double.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;

                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) continue;

                    double d1 = Math.sqrt(Math.pow(p[i][0] - xS, 2) + Math.pow(p[i][1] - yS, 2));
                    double d2 = Math.sqrt(Math.pow(p[j][0] - p[i][0], 2) + Math.pow(p[j][1] - p[i][1], 2));
                    double d3 = Math.sqrt(Math.pow(p[k][0] - p[j][0], 2) + Math.pow(p[k][1] - p[j][1], 2));

                    double total = d1 + d2 + d3;
                    if (total < minTotalDist) {
                        minTotalDist = total;
                    }
                }
            }
        }

        System.out.println((int) minTotalDist);
    }
}