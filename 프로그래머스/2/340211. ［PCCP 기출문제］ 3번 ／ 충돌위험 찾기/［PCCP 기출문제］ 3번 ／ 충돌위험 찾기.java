import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int x = routes.length;
        List<List<int[]>> robotPaths = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            List<int[]> path = new ArrayList<>();
            int[] route = routes[i];

            int startPointIdx = route[0] - 1;
            int curR = points[startPointIdx][0];
            int curC = points[startPointIdx][1];
            path.add(new int[]{curR, curC});

            for (int j = 1; j < route.length; j++) {
                int endPointIdx = route[j] - 1;
                int endR = points[endPointIdx][0];
                int endC = points[endPointIdx][1];

                while (curR != endR || curC != endC) {
                    if (curR != endR) {
                        curR += (endR > curR) ? 1 : -1;
                    } else if (curC != endC) {
                        curC += (endC > curC) ? 1 : -1;
                    }
                    path.add(new int[]{curR, curC});
                }
            }
            robotPaths.add(path);
        }

        int maxTime = 0;
        for (List<int[]> path : robotPaths) {
            maxTime = Math.max(maxTime, path.size());
        }

        int dangerCount = 0;

        for (int t = 0; t < maxTime; t++) {
            int[][] mapCount = new int[101][101];

            for (int i = 0; i < x; i++) {
                List<int[]> path = robotPaths.get(i);
                if (t < path.size()) {
                    int[] pos = path.get(t);
                    mapCount[pos[0]][pos[1]]++;
                }
            }

            for (int r = 1; r <= 100; r++) {
                for (int c = 1; c <= 100; c++) {
                    if (mapCount[r][c] >= 2) {
                        dangerCount++;
                    }
                }
            }
        }

        return dangerCount;
    }
}