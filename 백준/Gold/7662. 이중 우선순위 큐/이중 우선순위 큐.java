import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(c == 'I') treeMap.put(n, treeMap.getOrDefault(n, 0)+1);
                else {
                    if(treeMap.isEmpty()) continue;
                    int key;

                    if(n == 1) key = treeMap.lastKey(); // 최대키
                    else key = treeMap.firstKey(); // 최소키

                    int val = treeMap.get(key);
                    if(val == 1) treeMap.remove(key);
                    else treeMap.put(key, val-1);
                }
            }
            if(treeMap.isEmpty()) sb.append("EMPTY\n");
            else sb.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}