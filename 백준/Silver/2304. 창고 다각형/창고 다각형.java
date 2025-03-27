import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> pillars = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pillars.add(new int[]{x, h});
        }

        pillars.sort(Comparator.comparingInt(a -> a[0]));

        int maxH = 0, maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (pillars.get(i)[1] > maxH) {
                maxH = pillars.get(i)[1];
                maxIdx = i;
            }
        }

        int area = 0;
        int leftMaxH = pillars.get(0)[1];
        int leftX = pillars.get(0)[0];

        for (int i = 1; i <= maxIdx; i++) {
            int curX = pillars.get(i)[0];
            int curH = pillars.get(i)[1];

            if (curH > leftMaxH) {
                area += leftMaxH * (curX - leftX);
                leftMaxH = curH;
                leftX = curX;
            }
        }

        int rightMaxH = pillars.get(N - 1)[1];
        int rightX = pillars.get(N - 1)[0];

        for (int i = N - 2; i >= maxIdx; i--) {
            int curX = pillars.get(i)[0];
            int curH = pillars.get(i)[1];

            if (curH > rightMaxH) {
                area += rightMaxH * (rightX - curX);
                rightMaxH = curH;
                rightX = curX;
            }
        }

        area += maxH * (rightX - pillars.get(maxIdx)[0] + 1);

        System.out.println(area);
    }
}
