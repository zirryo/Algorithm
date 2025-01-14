import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] isBlocked = new boolean[1001][1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            isBlocked[x + 500][y + 500] = true;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        char[] dir = {'U', 'D', 'L', 'R'};

        int x = 500;
        int y = 500;

        char[] command = br.readLine().toCharArray();
        for (char c : command) {
            for (int i = 0; i < 4; i++) {
                if (c == dir[i]) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(!isBlocked[nx][ny]) {
                        x = nx;
                        y = ny;
                    }
                    break;
                }
            }
        }

        x -= 500;
        y -= 500;

        System.out.println(x  + " " + y);
    }
}