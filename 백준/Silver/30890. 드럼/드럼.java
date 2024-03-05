import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N*M; i++) {
            if (i % N == 0 && i % M == 0) sb.append("3");
            else {
                if (i % M == 0) sb.append("1");
                else if (i % N == 0) sb.append("2");
            }
        }
        System.out.println(sb);
    }
}