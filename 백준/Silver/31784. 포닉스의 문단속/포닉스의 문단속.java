import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            int move = (26 - (s[i] - 'A')) % 26;
            if (move <= K) {
                K -= move;
                s[i] = 'A';
            }
        }

        s[N - 1] = (char)((s[N - 1] - 'A' + K) % 26 + 'A');

        System.out.println(new String(s));
    }
}
