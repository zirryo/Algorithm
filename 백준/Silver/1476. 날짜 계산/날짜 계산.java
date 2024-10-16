import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            year++;
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;
        }

        // 최대 반복 횟수 = 7980(E * S * M)
    }
}

