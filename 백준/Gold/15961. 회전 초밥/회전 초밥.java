import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n + k];
        for (int i = 1; i <= n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n + 1; i < n + k; i++) {
            sushi[i] = sushi[i - n];
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < sushi.length; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
            if (i >= k) {
                if (map.containsKey(c)) {
                    max = Math.max(max, map.size());
                } else {
                    max = Math.max(max, map.size() + 1);
                }
                if (map.get(sushi[i - k + 1]) == 1) map.remove(sushi[i - k + 1]);
                else map.put(sushi[i - k + 1], map.getOrDefault(sushi[i - k + 1], 0) - 1);
            }
        }

        System.out.println(max);
    }
}