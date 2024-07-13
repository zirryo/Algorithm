import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] castle;
    static boolean[][] visited;
    static int[] roomSizes;
    static int[][] roomIds;
    static int roomCount = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        visited = new boolean[N][M];
        roomIds = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Find the number of rooms and the maximum room size
        List<Integer> roomSizesList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int roomSize = bfs(i, j, roomCount);
                    roomSizesList.add(roomSize);
                    roomCount++;
                }
            }
        }

        roomSizes = new int[roomCount];
        for (int i = 0; i < roomCount; i++) {
            roomSizes[i] = roomSizesList.get(i);
        }

        int maxRoomSize = Arrays.stream(roomSizes).max().orElse(0);
        int maxCombinedRoomSize = getMaxCombinedRoomSize();

        System.out.println(roomCount);
        System.out.println(maxRoomSize);
        System.out.println(maxCombinedRoomSize);
    }

    static int bfs(int startX, int startY, int roomId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        roomIds[startX][startY] = roomId;

        int roomSize = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            roomSize++;

            for (int i = 0; i < 4; i++) {
                if ((castle[x][y] & (1 << i)) == 0) { // No wall in direction i
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        roomIds[nx][ny] = roomId;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return roomSize;
    }

    static int getMaxCombinedRoomSize() {
        int maxCombinedRoomSize = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni >= 0 && nj >= 0 && ni < N && nj < M && (castle[i][j] & (1 << k)) != 0) {
                        int room1 = roomIds[i][j];
                        int room2 = roomIds[ni][nj];

                        if (room1 != room2) {
                            int combinedRoomSize = roomSizes[room1] + roomSizes[room2];
                            maxCombinedRoomSize = Math.max(maxCombinedRoomSize, combinedRoomSize);
                        }
                    }
                }
            }
        }

        return maxCombinedRoomSize;
    }
}
