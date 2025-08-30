import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long sumA = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sumA += Long.parseLong(st.nextToken());
        }

        long prodB = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long b = Long.parseLong(st.nextToken());
            if (b >= 1) prodB *= b;
        }

        long answer = sumA * prodB;
        System.out.println(answer);
    }
}
