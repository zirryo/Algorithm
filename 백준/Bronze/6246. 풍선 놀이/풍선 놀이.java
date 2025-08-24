import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] occupied = new boolean[N + 1];

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());

            for (int pos = L; pos <= N; pos += I) {
                if (!occupied[pos]) {
                    occupied[pos] = true;
                }
            }
        }

        int empty = 0;
        for (int i = 1; i <= N; i++) {
            if (!occupied[i]) empty++;
        }

        System.out.println(empty);
    }
}
