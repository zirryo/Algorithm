import java.io.*;
import java.util.*;

public class Main {
    static final int ROTATE_TIME = 5;
    static final int FLOOR_TIME = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] building = new int[h][l];
            Map<Integer, int[]> carMap = new TreeMap<>();

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) {
                    building[i][j] = Integer.parseInt(st.nextToken());
                    if (building[i][j] != -1) {
                        carMap.put(building[i][j], new int[]{i, j});
                    }
                }
            }

            int[] elevatorPos = new int[h];
            int totalTime = 0;

            for (int car : carMap.keySet()) {
                int[] pos = carMap.get(car);
                int floor = pos[0];
                int carIdx = pos[1];
                int curElevator = elevatorPos[floor];

                int clockwise = (carIdx - curElevator + l) % l;
                int counterClockwise = (curElevator - carIdx + l) % l;
                int rotateTime = Math.min(clockwise, counterClockwise) * ROTATE_TIME;
                int moveTime = floor * FLOOR_TIME * 2;

                totalTime += rotateTime + moveTime;
                elevatorPos[floor] = carIdx;
            }

            System.out.println(totalTime);
        }
    }
}
