import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());
        long sum = 0, xor = 0;

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                long X = Long.parseLong(st.nextToken());
                sum += X;
                xor ^= X;
            } else if (type == 2) {
                long X = Long.parseLong(st.nextToken());
                sum -= X;
                xor ^= X;
            } else if (type == 3) {
                sb.append(sum).append("\n");
            } else { // 4: xor 출력
                sb.append(xor).append("\n");
            }
        }
        System.out.print(sb);
    }
}
