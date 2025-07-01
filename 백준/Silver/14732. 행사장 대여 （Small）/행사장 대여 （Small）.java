import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 501;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[SIZE][SIZE];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = true;
                }
            }
        }

        int area = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (map[x][y]) area++;
            }
        }

        System.out.println(area);
    }
}
