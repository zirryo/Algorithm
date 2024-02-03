import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int idx = 1;

        HashMap<Integer, Integer> order = new HashMap<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            if (!order.containsKey(X)) {
                order.put(X, idx++);
                cnt.put(X, 1);
            } else {
                cnt.put(X, cnt.get(X) + 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(cnt.keySet());

        keySet.sort((o1, o2) -> {
            if (cnt.get(o1) == cnt.get(o2)) {
                return order.get(o1) - order.get(o2);
            } else return cnt.get(o2).compareTo(cnt.get(o1));
        });

        for (int x : keySet) {
            int repeat = cnt.get(x);
            for (int i=0; i<repeat; i++) {
                sb.append(x).append(" ");
            }
        }
        System.out.println(sb);
    }
}