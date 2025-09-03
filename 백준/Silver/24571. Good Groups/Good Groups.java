import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        List<String[]> sameGroup = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            sameGroup.add(br.readLine().split(" "));
        }

        int Y = Integer.parseInt(br.readLine());
        List<String[]> diffGroup = new ArrayList<>();
        for (int i = 0; i < Y; i++) {
            diffGroup.add(br.readLine().split(" "));
        }

        int G = Integer.parseInt(br.readLine());
        Map<String, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < G; i++) {
            String[] group = br.readLine().split(" ");
            for (String name : group) {
                groupMap.put(name, i);
            }
        }

        int violations = 0;

        for (String[] pair : sameGroup) {
            String a = pair[0], b = pair[1];
            if (!groupMap.get(a).equals(groupMap.get(b))) {
                violations++;
            }
        }

        for (String[] pair : diffGroup) {
            String a = pair[0], b = pair[1];
            if (groupMap.get(a).equals(groupMap.get(b))) {
                violations++;
            }
        }

        System.out.println(violations);
    }
}
