import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> lastUsed = new HashMap<>();

        for (int time = 0; time < N; time++) {
            String container = br.readLine();
            lastUsed.put(container, time);
        }

        int K = Integer.parseInt(br.readLine());
        Set<String> pinned = new HashSet<>();
        for (int i = 0; i < K; i++) {
            pinned.add(br.readLine());
        }

        List<String> pinnedList = new ArrayList<>();
        List<String> othersList = new ArrayList<>();

        for (String name : lastUsed.keySet()) {
            if (pinned.contains(name)) {
                pinnedList.add(name);
            } else {
                othersList.add(name);
            }
        }

        Comparator<String> byRecentUsage = (a, b) -> lastUsed.get(b) - lastUsed.get(a);
        pinnedList.sort(byRecentUsage);
        othersList.sort(byRecentUsage);

        StringBuilder sb = new StringBuilder();

        for (String name : pinnedList) {
            sb.append(name).append("\n");
        }
        for (String name : othersList) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
