import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];

        boolean possible = true;
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (i % 2 != A[i] % 2) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}