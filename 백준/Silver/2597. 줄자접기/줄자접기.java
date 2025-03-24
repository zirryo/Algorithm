import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(br.readLine());
        List<double[]> nodes = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes.add(new double[]{Math.min(x, y), Math.max(x, y)});
        }

        for (int i = 0; i < 3; i++) {
            double x = nodes.get(i)[0], y = nodes.get(i)[1];
            if (x == y) continue;

            double mid = (x + y) / 2.0;
            if (length - mid <= mid) {
                length = mid;
                for (int j = i; j < 3; j++) {
                    double left = nodes.get(j)[0], right = nodes.get(j)[1];

                    if (mid < left) left = (int) (mid - (left - mid));
                    if (mid < right) right = (int) (mid - (right - mid));

                    nodes.set(j, new double[]{Math.min(left, right), Math.max(left, right)});
                }
            } else {
                length -= mid;
                for (int j = i + 1; j < 3; j++) {
                    double left = nodes.get(j)[0], right = nodes.get(j)[1];

                    left = left < mid ? (mid - left) : (left - mid);
                    right = right < mid ? (mid - right) : (right - mid);

                    nodes.set(j, new double[]{Math.min(left, right), Math.max(left, right)});
                }
            }
        }
        System.out.printf("%.1f\n", length);
    }
}
