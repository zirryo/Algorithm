import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> xCntByPos = new HashMap<>();
        Map<Long, Integer> yCntByPos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            xCntByPos.put(x, xCntByPos.getOrDefault(x, 0) + 1);
            yCntByPos.put(y, yCntByPos.getOrDefault(y, 0) + 1);
        }

        int result = 0;

        for (int count : xCntByPos.values()) {
            if (count >= 2) {
                result++;
            }
        }

        for (int count : yCntByPos.values()) {
            if (count >= 2) {
                result++;
            }
        }

        System.out.println(result);
    }
}