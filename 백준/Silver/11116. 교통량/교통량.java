import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int m = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> leftTimes = new ArrayList<>();
            for (int i = 0; i < m; i++) leftTimes.add(Integer.parseInt(st.nextToken()));
            Set<Integer> leftSet = new HashSet<>(leftTimes);
            Set<Integer> rightSet = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) rightSet.add(Integer.parseInt(st.nextToken()));


            int count = 0;

            for (int t : leftTimes) {
                if (!leftSet.contains(t) || !leftSet.contains(t + 500)) continue;
                if (!rightSet.contains(t + 1000) || !rightSet.contains(t + 1500)) continue;

                count++;

                leftSet.remove(t);
                leftSet.remove(t + 500);
                rightSet.remove(t + 1000);
                rightSet.remove(t + 1500);
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
