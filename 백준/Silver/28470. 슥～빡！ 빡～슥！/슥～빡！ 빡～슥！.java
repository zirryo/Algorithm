import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        double[] K = new double[N];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            K[i] = Double.parseDouble(st.nextToken());
        }

        long adrenaline = 0;

        for (int i = 0; i < N; i++) {
            long attackFirst = (long) (K[i] * 10 * A[i]) / 10 - B[i];
            long dodgeFirst  = A[i] - (long) Math.floor(K[i] * 10 * B[i]) / 10;

            adrenaline += Math.max(attackFirst, dodgeFirst);
        }

        System.out.println(adrenaline);
    }
}
