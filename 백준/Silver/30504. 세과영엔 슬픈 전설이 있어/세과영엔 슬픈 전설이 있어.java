import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int value, index;
        Pair(int v, int i) { value = v; index = i; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        Pair[] aArr = new Pair[N];
        for (int i = 0; i < N; i++) aArr[i] = new Pair(A[i], i);

        Arrays.sort(aArr, Comparator.comparingInt(p -> p.value));
        Arrays.sort(B);

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int need = aArr[i].value;


            if (need > B[i]) {
                System.out.println(-1);
                return;
            }

            result[aArr[i].index] = B[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(result[i]).append(' ');
        System.out.println(sb.toString().trim());
    }
}
