import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> orderMap;
    static String[] hw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int correct = 0;
        int N = Integer.parseInt(br.readLine());
        orderMap = new HashMap<>();
        hw = new String[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            orderMap.put(st.nextToken(), i);
            hw[i] = st1.nextToken();
        }

        for (int i = 1; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                if (orderMap.get(hw[i]) < orderMap.get(hw[j])) correct++;
            }
        }

        System.out.println(correct + "/" + N*(N-1)/2);
    }
}