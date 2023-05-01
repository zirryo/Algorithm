import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] block = new int[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Pos> explosion;
    static Queue<Pos> q;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 12; i++) {
            String s = br.readLine();
            for(int j = 0; j < 6; j++) {
                char c = s.charAt(j);
                if(c=='R') block[i][j] = 1;
                else if(c=='G') block[i][j] = 2;
                else if(c=='B') block[i][j] = 3;
                else if(c=='P') block[i][j] = 4;
                else if(c=='Y') block[i][j] = 5;
            }
        }
        getScore();
        System.out.println(ans);
    }
    private static void getScore() {
        while (true) {
            boolean flag = false;
            visited = new boolean[12][6];
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(block[i][j] == 0 || visited[i][j]) continue;
                    fourBlocks(i, j);
                    if(explosion.size() >= 4) flag = true;
                    else {
                        for(Pos pos : explosion) {
                            visited[pos.x][pos.y] = false;
                        }
                    }
                }
            }
            if (flag) ans++;
            else break;

            relocate();
        }
    }
    private static void fourBlocks(int x, int y) {
        int cur = block[x][y];
        explosion = new ArrayList<>();
        q = new LinkedList<>();
        q.add(new Pos(x, y));
        visited[x][y] = true;
        explosion.add(new Pos(x, y));

        while (!q.isEmpty()) {
            Pos curP = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny] && block[nx][ny] == cur) {
                    q.add(new Pos(nx, ny));
                    explosion.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < 12 && y >= 0 && y < 6;
    }
    private static void relocate() {
        ArrayList<Integer>[] blockList = new ArrayList[6];
        for(int i = 0; i < 6; i++) blockList[i] = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            for(int j = 11; j >= 0; j--) {
                if(!visited[j][i] && block[j][i] != 0) blockList[i].add(block[j][i]);
            }
        }
        block = new int[12][6];
        for(int i = 0; i < 6; i++) {
            for(int j = 11; j >= 0; j--) {
                if(!blockList[i].isEmpty()) {
                    block[j][i] = blockList[i].get(0);
                    blockList[i].remove(0);
                } else break;
            }
        }
    }
    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}