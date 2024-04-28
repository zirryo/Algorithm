import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Point[] arr = new Point[4];
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            boolean flag = isRectangle(arr);
            if (flag) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);

    }
    private static boolean isRectangle(Point[] arr) {
        long[] dist = new long[6];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j <= 3; j++) {
                dist[idx++] = (long) Math.pow(Math.abs(arr[i].x - arr[j].x), 2) + (long) Math.pow(Math.abs(arr[i].y - arr[j].y), 2);
            }
        }

        Arrays.sort(dist);
        if (dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3] && dist[4] == dist[5]) return true;
        return false;
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
