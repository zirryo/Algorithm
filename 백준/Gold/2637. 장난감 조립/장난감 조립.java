import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ToyPart>[] toyParts;
    static int[] indegree, basePart, needs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        toyParts = new ArrayList[N+1];
        indegree = new int[N+1];
        basePart = new int[N+1];
        needs = new int[N+1];
        for (int i=1; i<=N; i++) {
            toyParts[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            toyParts[x].add(new ToyPart(y, k));
            indegree[y]++;
            basePart[x]++;
        }

        topologySort();
        for (int i=1; i<N; i++) {
            if(basePart[i] == 0) sb.append(i).append(" ").append(needs[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void topologySort() {
        Queue<ToyPart> q = new LinkedList<>();
        q.add(new ToyPart(N, 1));
        needs[N] = 1;

        while (!q.isEmpty()) {
            ToyPart cur = q.poll();
            for (ToyPart next : toyParts[cur.num]) {
                needs[next.num] += needs[cur.num] * next.pieces;
                indegree[next.num]--;
                if (indegree[next.num] == 0) {
                    q.add(new ToyPart(next.num, needs[next.num]));
                }
            }
        }
    }
}
class ToyPart {
    int num;
    int pieces;

    public ToyPart(int num, int pieces) {
        this.num = num;
        this.pieces = pieces;
    }
}