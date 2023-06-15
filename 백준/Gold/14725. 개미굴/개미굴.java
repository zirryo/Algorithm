import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node();
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node cur = root;

            for (int j = 0; j < K; j++) {
                String s = st.nextToken();

                if (!cur.childMap.containsKey(s)) {
                    cur.childMap.put(s, new Node());
                }

                cur = cur.childMap.get(s);
            }
        }

        makeAntNest(root, "");
        System.out.println(sb);
    }
    private static void makeAntNest(Node node, String str) {
        Object[] keyArr = node.childMap.keySet().toArray();
        Arrays.sort(keyArr); // 사전순으로 정렬

        for (Object o : keyArr) {
            sb.append(str).append(o).append("\n");
            makeAntNest(node.childMap.get(o), str + "--");
        }
    }
    private static class Node {
        Map<String, Node> childMap = new HashMap<>();
    }
}