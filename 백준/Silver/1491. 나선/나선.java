import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0, y = 0;
        int dir = 0;
        int width = N, height = M;

        while (true) {
            int move = (dir % 2 == 0) ? width : height;
            if (move == 0) break;

            x += dx[dir] * (move - 1);
            y += dy[dir] * (move - 1);

            if (dir == 0) {
                height--;
            } else if (dir == 1) {
                width--;
            } else if (dir == 2) {
                height--;
            } else {
                width--;
            }

            dir = (dir + 1) % 4;

           
            int nextMove = (dir % 2 == 0) ? width : height;
            if (nextMove == 0) break;
            
            x += dx[dir];
            y += dy[dir];
        }

        System.out.println(x + " " + y);
    }
}
