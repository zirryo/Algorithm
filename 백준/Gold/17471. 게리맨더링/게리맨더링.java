import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 1001;
    static int[] pop;
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pop = new int[N+1];
        lists = new ArrayList[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++) {
                int y = Integer.parseInt(st.nextToken());
                lists[i].add(y);
            }
        }
        ArrayList<Integer> teamA;
        ArrayList<Integer> teamB;
        for (int i = 2; i < (1 << (N + 1)) - 3; i++) { // 각 선거구는 최소 하나의 구역을 포함
            teamA = new ArrayList<>();
            teamB = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if ((i & (1 << j)) != 0) teamA.add(j);
                else teamB.add(j);
            }

            if (connectArea(teamA) && connectArea(teamB)) {
                int a = 0;
                int b = 0;
                for (int k : teamA) a += pop[k];
                for (int k : teamB) b += pop[k];

                result = Math.min(result, Math.abs(a - b));
            }
        }
        
        if (result == 1001) System.out.println(-1);
        else System.out.println(result);
    }
    private static boolean connectArea(ArrayList<Integer> team) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        check[team.get(0)] = true;
        q.add(team.get(0));
        int teamArea = 0;

        while (!q.isEmpty()) {
            teamArea++;
            int cur = q.poll();
            for (int next : lists[cur]) {
                if (check[next] || !team.contains(next)) continue;
                check[next] = true;
                q.add(next);
            }
        }

        return teamArea == team.size();
    }
}