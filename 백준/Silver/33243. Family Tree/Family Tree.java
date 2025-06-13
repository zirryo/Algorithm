import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String root = br.readLine();
        Map<String, List<String>> tree = new HashMap<>();

        for (int i = 1; i < N; i++) {
            String[] tokens = br.readLine().split(" - ");
            String parent = tokens[0];
            String child = tokens[1];
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        Queue<String> q = new LinkedList<>();
        q.offer(root);

        int width = 0;

        while (!q.isEmpty()) {
            int curWidth = q.size();
            width = Math.max(width, curWidth);

            for (int i = 0; i < curWidth; i++) {
                String cur = q.poll();
                List<String> children = tree.get(cur);
                if (children != null) {
                    for (String child : children) {
                        q.offer(child);
                    }
                }
            }
        }

        System.out.println(width);
    }
}