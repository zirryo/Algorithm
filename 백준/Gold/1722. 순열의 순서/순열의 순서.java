import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] fac;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fac = new long[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            if (i == 0) fac[i] = 1;
            else fac[i] = fac[i-1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        if (X == 1) {
            long K = Long.parseLong(st.nextToken());
            questionOne(K);
        } else if(X == 2) {
            int[] target = new int[N];
            for (int i=0; i<N; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }
            questionTwo(target);
        }
    }
    private static void questionOne(long K) {
        int[] result = new int[N];
        for (int idx = 0; idx < N; idx++) {
           for (int num = 1; num <= N; num++) {
               if (visited[num]) continue;

               if (K > fac[N-1-idx]) {
                   K -= fac[N-1-idx];
               } else {
                   result[idx] = num;
                   visited[num] = true;
                   break;
               }
           }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) sb.append(r).append(" ");
        System.out.println(sb);
    }
    private static void questionTwo(int[] target) {
        long result = 1;
        for (int idx = 0; idx < N; idx++) {
            for (int num = 1; num < target[idx]; num++) {
                if (visited[num]) continue;
                result += fac[N-1-idx];
            }
            visited[target[idx]] = true;
        }
        System.out.println(result);
    }
}