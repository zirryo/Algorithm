import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> anagramGroups = new HashMap<>();
        Map<String, Integer> groupSize = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            anagramGroups.putIfAbsent(key, new ArrayList<>());
            anagramGroups.get(key).add(line);
            groupSize.put(key, groupSize.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<String, List<String>>> sortedGroups = new ArrayList<>(anagramGroups.entrySet());
        sortedGroups.sort((e1, e2) -> {
            int sizeDiff = groupSize.get(e2.getKey()) - groupSize.get(e1.getKey());
            if (sizeDiff != 0) {
                return sizeDiff;
            }
            return e1.getValue().get(0).compareTo(e2.getValue().get(0));
        });

        int count = 0;
        for (Map.Entry<String, List<String>> entry : sortedGroups) {
            if (count == 5) break;

            List<String> words = new ArrayList<>(new HashSet<>(entry.getValue()));
            Collections.sort(words);

            sb.append("Group of size ").append(groupSize.get(entry.getKey())).append(": ")
                    .append(String.join(" ", words)).append(" .\n");
            count++;
        }

        System.out.print(sb);
    }
}
