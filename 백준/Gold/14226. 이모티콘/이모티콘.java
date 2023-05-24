import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<Emoticon> pq = new LinkedList<>();
        boolean[][] visited = new boolean[2*S][2*S];
        visited[1][0] = true;
        pq.add(new Emoticon(1, 0, 0));

        while(!pq.isEmpty()) {
            Emoticon cur = pq.poll();

            if (cur.emo == S) return cur.cnt;

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            pq.add(new Emoticon(cur.emo, cur.cnt + 1, cur.emo));

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (cur.clipboard != 0 && cur.emo + cur.clipboard <= S && !visited[cur.emo + cur.clipboard][cur.clipboard]) {
                pq.add(new Emoticon(cur.emo + cur.clipboard, cur.cnt + 1, cur.clipboard));
                visited[cur.emo + cur.clipboard][cur.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (cur.emo > 1 && !visited[cur.emo - 1][cur.clipboard]) {
                pq.add(new Emoticon(cur.emo - 1, cur.cnt + 1, cur.clipboard));
                visited[cur.emo - 1][cur.clipboard] = true;
            }
        }
        return 0;
    }
    private static class Emoticon implements Comparable<Emoticon> {
        int emo;
        int cnt;
        int clipboard;

        public Emoticon(int emo, int cnt, int clipboard) {
            this.emo = emo;
            this.cnt = cnt;
            this.clipboard = clipboard;
        }

        @Override
        public int compareTo(Emoticon emoticon) {
            return this.cnt - emoticon.cnt;
        }
    }
}