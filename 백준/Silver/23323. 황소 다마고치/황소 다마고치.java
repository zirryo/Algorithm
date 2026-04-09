import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long noFeedDays = 0;
            long tempN = n;
            while (tempN > 1) {
                tempN /= 2;
                noFeedDays++;
            }

            long totalDays = noFeedDays + m + 1;

            sb.append(totalDays).append("\n");
        }
        System.out.print(sb);
    }
}