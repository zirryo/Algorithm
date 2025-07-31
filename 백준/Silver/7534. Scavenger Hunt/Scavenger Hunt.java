import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int S = Integer.parseInt(br.readLine());
            Map<String, String> nextMap = new HashMap<>();
            Map<String, String> prevMap = new HashMap<>();
            Set<String> steps = new HashSet<>();

            for (int i = 0; i < S - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();

                nextMap.put(from, to);
                prevMap.put(to, from);
                steps.add(from);
                steps.add(to);
            }

            String start = "";
            for (String step : steps) {
                if (!prevMap.containsKey(step)) {
                    start = step;
                    break;
                }
            }

            List<String> route = new ArrayList<>();
            String current = start;
            while (current != null) {
                route.add(current);
                current = nextMap.get(current);
            }
            
            sb.append("Scenario #").append(t).append(":\n");
            for (String step : route) {
                sb.append(step).append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
