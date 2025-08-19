import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long totalUnread = 0;
        Map<Integer, Integer> lastSent = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            int sender = Integer.parseInt(br.readLine());

            totalUnread += (n - 1);

            int last = lastSent.getOrDefault(sender, 0);
            long unreadOfSender = (i - 1) - last;
            totalUnread -= unreadOfSender;
            
            lastSent.put(sender, i);

            sb.append(totalUnread).append("\n");
        }
        System.out.print(sb);
    }
}
