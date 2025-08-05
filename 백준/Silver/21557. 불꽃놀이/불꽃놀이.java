import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int leftFinal = A[0] - (N - 2);
        int rightFinal = A[N - 1] - (N - 2);

        leftFinal = Math.max(0, leftFinal);
        rightFinal = Math.max(0, rightFinal);

        System.out.println(Math.max(leftFinal, rightFinal));
    }
}
