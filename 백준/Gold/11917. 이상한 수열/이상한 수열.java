import java.io.*;
import java.util.*;

public class Main {
    static final int OFFSET = 1000000;
    static final int MAX_VAL = 2000005;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        boolean[] exists = new boolean[MAX_VAL];
        int distinctCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            if (!exists[S[i] + OFFSET]) {
                exists[S[i] + OFFSET] = true;
                distinctCount++;
            }
        }

        long M = Long.parseLong(br.readLine());

        if (M <= N) {
            System.out.println(S[(int)M - 1]);
            return;
        }
        
        long currentVal = distinctCount;
        int limit = -1;
        int searchMax = 1000000;
        
        if (currentVal <= searchMax) {
            for (int v = (int)currentVal; v <= searchMax; v++) {
                if (exists[v + OFFSET]) {
                    limit = v;
                    break;
                }
            }
        }
        
        if (limit == -1) {
            System.out.println(currentVal + (M - (N + 1)));
        } else {
            long steps = limit - currentVal;
            long limitIndex = (N + 1) + steps;

            if (M > limitIndex) {
                System.out.println(limit);
            } else {
                System.out.println(currentVal + (M - (N + 1)));
            }
        }
    }
}