import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> colorMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            colorMap.putIfAbsent(color, new ArrayList<>());
            colorMap.get(color).add(x);
        }

        int totalLength = 0;

        for (List<Integer> points : colorMap.values()) {
            Collections.sort(points);

            for (int i = 0; i < points.size(); i++) {
                int leftDist = (i > 0) ? points.get(i) - points.get(i - 1) : 100_000;
                int rightDist = (i < points.size() - 1) ? points.get(i + 1) - points.get(i) : 100_000;

                totalLength += Math.min(leftDist, rightDist);
            }
        }

        System.out.println(totalLength);
    }
}
