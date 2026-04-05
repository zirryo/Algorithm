import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;

        for (int i = 1; i < L - 1; i++) {
            if (A[i] > A[i + 1]) {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (int i = R + 1; i < N; i++) {
                if (A[i] > A[i + 1]) {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            int minVal = 1_000_000_001;
            int maxVal = 0;

            for (int i = L; i <= R; i++) {
                minVal = Math.min(minVal, A[i]);
                maxVal = Math.max(maxVal, A[i]);
            }

            if (L > 1 && A[L - 1] > minVal) {
                possible = false;
            }
            if (R < N && maxVal > A[R + 1]) {
                possible = false;
            }
        }

        System.out.println(possible ? 1 : 0);
    }
}