import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int medianX = x[n / 2];
        int medianY = y[n / 2];

        long minDistance = 0;
        for (int i = 0; i < n; i++) {
            minDistance += Math.abs(x[i] - medianX);
            minDistance += Math.abs(y[i] - medianY);
        }

        System.out.println(minDistance);
    }
}
