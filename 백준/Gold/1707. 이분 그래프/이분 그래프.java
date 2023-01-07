import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] list; // 간선 배열
    static int[] group; // 그룹 1, 그룹 2 로 분류
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            group = new int[V+1];

            for(int i=1; i<=V; i++) {
                list[i] = new ArrayList<>();
            }

            while(E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }
            bfs();
        }
        System.out.println(sb);
    }
    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=V; i++) {
            if(group[i] == 0) {
                q.add(i);
                group[i] = 1;
            }

            while(!q.isEmpty()) {
                int temp = q.poll();

                for(int j=0; j<list[temp].size(); j++) {

                    // 인접한 정점이 같은 그룹에 속하면 NO
                    if(group[list[temp].get(j)] == group[temp]) {
                        sb.append("NO\n");
                        return;
                    }

                    if(group[list[temp].get(j)] == 0) {
                        q.add(list[temp].get(j));

                        if(group[temp] == 1) {
                            group[list[temp].get(j)] = 2;
                        } else if (group[temp] == 2) {
                            group[list[temp].get(j)] = 1;
                        }
                    }
                }
            }
        }

        // 모든 정점에서 bfs -> 인접한 정점이 같은 그룹에 속하는 경우가 없다면 YES
        sb.append("YES\n");

    }

}