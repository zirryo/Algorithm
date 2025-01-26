import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;
        int direction = 0;

        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("MOVE")) {
                int steps = Integer.parseInt(st.nextToken());
                x += dx[direction] * steps;
                y += dy[direction] * steps;

                if (x < 0 || x > L || y < 0 || y > L) {
                    System.out.println(-1);
                    return;
                }
            } else if (command.equals("TURN")) {
                int turnDirection = Integer.parseInt(st.nextToken());
                if (turnDirection == 0) {
                    direction = (direction + 3) % 4;
                } else if (turnDirection == 1) {
                    direction = (direction + 1) % 4;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
