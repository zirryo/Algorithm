import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = br.readLine().length();

        long answer = 0;
        for(int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i=0; i < N-1; i++) {
            if(map.get(arr[i]) == 1) {
                map.remove(arr[i]);
            } else map.put(arr[i], map.get(arr[i]) - 1);
            if(i+K < N) map.put(arr[i+K], map.getOrDefault(arr[i+K], 0) + 1);
            answer += map.getOrDefault(arr[i], 0);
        }

        System.out.println(answer);
    }
}