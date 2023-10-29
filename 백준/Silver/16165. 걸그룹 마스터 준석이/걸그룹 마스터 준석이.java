import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> quiz1 = new HashMap<>();
        Map<String, String[]> quiz0 = new HashMap<>();
        for (int i=0; i<N; i++) {
            String teamName = br.readLine();
            int x = Integer.parseInt(br.readLine());
            String[] group = new String[x];
            for (int j=0; j<x; j++) {
                String name = br.readLine();
                quiz1.put(name, teamName);
                group[j] = name;
            }
            quiz0.put(teamName, group);
        }

        Object[] keySet = quiz0.keySet().toArray();
        for (Object o : keySet) {
            Arrays.sort(quiz0.get(o.toString()));
        }

        for (int i = 0; i < M; i++) {
            String q2 = br.readLine();
            int q1 = Integer.parseInt(br.readLine());

            if (q1 == 1) sb.append(quiz1.get(q2)).append("\n");
            if (q1 == 0) {
                String[] answer = quiz0.get(q2);
                for (String a : answer) {
                    sb.append(a).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}