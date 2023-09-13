import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Problem> set = new TreeSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(num, level);
            set.add(new Problem(num, level));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    sb.append(set.first().num).append("\n");
                } else {
                    sb.append(set.last().num).append("\n");
                }
            }
            else if(command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                map.put(P, L);
                set.add(new Problem(P, L));
            }
            else if(command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                set.remove(new Problem(P, map.get(P)));
                map.remove(P);
            }
        }

        System.out.println(sb);
    }
}
class Problem implements Comparable<Problem> {
    int num;
    int level;

    public Problem(int num, int level) {
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Problem p) {
        if (p.level == this.level) return p.num - this.num;
        return p.level - this.level;
    }
}