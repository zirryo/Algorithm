import java.io.*;
import java.util.*;

public class Main {
    static class Cafe {
        int x, y, index;
        Cafe(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Cafe> cafes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cafes.add(new Cafe(x, y, i + 1));
            }

            cafes.sort(Comparator.comparingInt(c -> c.x));

            Map<Integer, Cafe> cafeMap = new HashMap<>();

            int currentIndex = 1;
            int lastY = 0;

            for (int i = 0; i < n; ) {
                int currentX = cafes.get(i).x;
                List<Cafe> sameXList = new ArrayList<>();

                while (i < n && cafes.get(i).x == currentX) {
                    sameXList.add(cafes.get(i));
                    i++;
                }

                Cafe startCafe = null;
                for (Cafe c : sameXList) {
                    if (c.y == lastY) {
                        startCafe = c;
                        break;
                    }
                }

                if (startCafe != null) {
                    cafeMap.put(currentIndex++, startCafe);
                    sameXList.remove(startCafe);

                }

                final int tempY = lastY;
                PriorityQueue<Cafe> pq = new PriorityQueue<>(Comparator.comparingInt(a -> Math.abs(tempY - a.y)));
                pq.addAll(sameXList);

                while (!pq.isEmpty()) {
                    Cafe nextCafe = pq.poll();
                    cafeMap.put(currentIndex++, nextCafe);
                    lastY = nextCafe.y;
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                int query = Integer.parseInt(st.nextToken());
                Cafe result = cafeMap.get(query);
                sb.append(result.x).append(" ").append(result.y).append("\n");
            }
        }

        System.out.print(sb);
    }
}
