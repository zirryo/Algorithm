import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int idx = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.get(arr[i]) > K) {
                map.put(arr[idx], map.get(arr[idx]) - 1);
                idx++;
            }

            result = Math.max(result, i - idx + 1);
        }
        System.out.println(result);
    }
}