import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int W;
    public static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            int cnt = 0;

            while(K-->0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int row=0; row<H; row++) {
                for(int col=0; col<W; col++) {
                    if(map[row][col] == 0) continue;
                    cnt++;
                    map = putWorms(row, col, map);
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
    public static int[][] putWorms(int row, int col, int[][] map) {
        if(row<0 || row>=H || col<0 || col>=W) return map;
        if(map[row][col]==0) return map;
        map[row][col] = 0;
        map = putWorms(row-1, col, map);
        map = putWorms(row, col-1, map);
        map = putWorms(row+1, col, map);
        map = putWorms(row, col+1, map);
        return map;
    }
}