import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String>[] childList = new List[N];
        List<String>[] resultChild = new List[N];
        String[] names = new String[N];
        int[] degrees = new int[N];

        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
            childList[i] = new ArrayList<>();
            resultChild[i] = new ArrayList<>();
        }

        Arrays.sort(names);
        HashMap<String, Integer> nameIdx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            nameIdx.put(names[i], i);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String p = st.nextToken();
            childList[nameIdx.get(p)].add(c);
            degrees[nameIdx.get(c)]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        List<String> roots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (degrees[i] == 0) {
                roots.add(names[i]);
                q.add(names[i]);
            }
        }

        while (!q.isEmpty()) {
            String cur = q.poll();

            for (String child : childList[nameIdx.get(cur)]) {
                int idx = nameIdx.get(child);
                degrees[idx]--;
                if (degrees[idx] == 0) {
                    q.add(names[idx]);
                    resultChild[nameIdx.get(cur)].add(child);
                }
            }
        }

        sb.append(roots.size() + "\n");
        for (String root : roots) {
            sb.append(root + " ");
        }
        sb.append("\n");

        for (String n : names) {
            int curIdx = nameIdx.get(n);
            sb.append(n + " " + resultChild[curIdx].size() + " ");
            Collections.sort(resultChild[curIdx]);
            for (String childName : resultChild[curIdx]) {
                sb.append(childName + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}