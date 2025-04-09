import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            int poster1Area = (x2 - x1) * (y2 - y1);

            int overlapX1 = Math.max(x1, x3);
            int overlapY1 = Math.max(y1, y3);
            int overlapX2 = Math.min(x2, x4);
            int overlapY2 = Math.min(y2, y4);

            int overlapWidth = Math.max(0, overlapX2 - overlapX1);
            int overlapHeight = Math.max(0, overlapY2 - overlapY1);
            int overlapArea = overlapWidth * overlapHeight;

            sb.append(poster1Area - overlapArea).append("\n");
        }

        System.out.print(sb);
    }
}
