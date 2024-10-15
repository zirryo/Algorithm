import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 북 -> 동 -> 님 -> 서
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            sb.append(simulate(commands)).append("\n");
        }

        System.out.print(sb);
    }

    static int simulate(String commands) {
        int x = 0, y = 0;
        int dir = 0;

        int xMin = 0, xMax = 0, yMin = 0, yMax = 0;

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'F':
                    x += dx[dir];
                    y += dy[dir];
                    break;
                case 'B':
                    x -= dx[dir];
                    y -= dy[dir];
                    break;
                case 'L':
                    dir = (dir + 3) % 4;
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
            }

            xMin = Math.min(xMin, x);
            xMax = Math.max(xMax, x);
            yMin = Math.min(yMin, y);
            yMax = Math.max(yMax, y);
        }

        return (xMax - xMin) * (yMax - yMin);
    }
}
