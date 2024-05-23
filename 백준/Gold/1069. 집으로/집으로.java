import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        double distance = Math.sqrt(x * x + y * y);

        double minTime = distance; // 걷기만 하는 경우
        int jumps = (int) (distance / d);
        double remainDistance = distance - jumps * d;

        // 걷기 + 점프 하는 경우
        minTime = Math.min(minTime, (jumps + 1) * t + (jumps + 1) * d - distance);
        minTime = Math.min(minTime, jumps * t + remainDistance);

        // 점프만 하는 경우
        if (jumps > 0) {
            minTime = Math.min(minTime, (jumps + 1) * t);
        } else {
            minTime = Math.min(minTime, t * 2);
        }


        System.out.print(minTime);
    }
}