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

        if (isMountain(A)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isMountain(int[] A) {
        int N = A.length;
        int i = 1;

        while (i < N && A[i - 1] < A[i]) {
            i++;
        }

        if (i == N) return true;

        while (i < N && A[i - 1] > A[i]) {
            i++;
        }

        if (i == N) return true;

        return false;
    }
}
