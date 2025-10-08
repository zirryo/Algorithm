import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[20]; 

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            for (int b = 0; b < 20; b++) {
                if ((x & (1 << b)) != 0) {
                    count[b]++;
                }
            }
        }

        int answer = 0;
        for (int c : count) {
            answer = Math.max(answer, c);
        }

        System.out.println(answer);
    }
}
