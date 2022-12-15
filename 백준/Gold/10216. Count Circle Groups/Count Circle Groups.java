import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Pos> list = new ArrayList<>();

            while(N-->0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                list.add(new Pos(x, y, r));
            }

            boolean[] isVisited = new boolean[list.size()];

            int group = 0;

            for(int i=0; i< list.size(); i++) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    bfs(list, i, isVisited);
                    group++;
                }
            }
            sb.append(group).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(ArrayList<Pos> posArrayList, int idx, boolean[] isVisited) {
        Queue<Pos> q = new LinkedList<>();
        q.add(posArrayList.get(idx));

        while(!q.isEmpty()) {
            Pos temp = q.poll();

            for(int i=0; i< posArrayList.size(); i++) {
                if(!isVisited[i] && temp.connect(posArrayList.get(i))) {
                    isVisited[i] = true;
                    q.add(posArrayList.get(i));
                }
            }
        }

    }

    public static class Pos {
        int x;
        int y;
        int r;

        public Pos(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean connect(Pos pos) {
            return Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2)) <= this.r + pos.r;
        }
    }

}