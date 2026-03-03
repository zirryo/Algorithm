import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = N;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sb.append(left++).append(" ");
            } else {
                sb.append(right--).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}