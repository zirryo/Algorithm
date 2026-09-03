import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        int curR = 0, curC = 0;

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (park[r].charAt(c) == 'S') {
                    curR = r;
                    curC = c;
                    break;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('N', 0);
        dirMap.put('S', 1);
        dirMap.put('W', 2);
        dirMap.put('E', 3);

        for (String route : routes) {
            String[] split = route.split(" ");
            char dir = split[0].charAt(0);
            int dist = Integer.parseInt(split[1]);

            int d = dirMap.get(dir);
            int nr = curR;
            int nc = curC;
            boolean isValid = true;

            for (int step = 0; step < dist; step++) {
                nr += dr[d];
                nc += dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                curR = nr;
                curC = nc;
            }
        }

        return new int[]{curR, curC};
    }
}