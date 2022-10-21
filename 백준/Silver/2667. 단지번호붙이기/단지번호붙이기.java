import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count;
    static List<Integer> aparts = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1 && !isVisited[i][j]) {
                    count = 1; // 새로운 단지를 발견한 경우 count를 1로 초기화
                    countHomes(i,j);
                    aparts.add(count);
                }
            }
        }
        Collections.sort(aparts);
        sb.append(aparts.size()).append("\n"); // 총 단지수
        for(int apart : aparts) sb.append(apart).append("\n");
        System.out.println(sb);
    }
    
    static int countHomes(int y, int x) {
        isVisited[y][x] = true;
        for(int i=0; i<4; i++) {
            int y1 = y + dy[i];
            int x1 = x + dx[i];

            if(inRange(y1,x1)) {
                if(map[y1][x1]==1 && !isVisited[y1][x1]) {
                    count++;
                    countHomes(y1, x1);
                }
            }
        }
        return count;
    }

    static boolean inRange(int y, int x) {
        if(y<0 || y>=N || x<0 || x>=N) return false;
        return true;
    }
}