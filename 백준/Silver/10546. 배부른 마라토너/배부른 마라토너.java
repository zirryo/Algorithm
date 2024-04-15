import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            int cnt = map.get(s);
            if (cnt > 1) map.put(s, cnt - 1);
            else if (cnt == 1) map.remove(s);
        }

        map.forEach((x, y) -> System.out.println(x));
    }
}