import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static List<int[]> points = new ArrayList<>();
    static int[][] distArr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];

        int[] start = null;
        int[] end = null;
        List<int[]> itemList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') start = new int[]{i, j};
                else if (map[i][j] == 'E') end = new int[]{i, j};
                else if (map[i][j] == 'X') itemList.add(new int[]{i, j});
            }
        }

        points.add(start);
        points.addAll(itemList);
        points.add(end);

        int pointCnt = points.size();
        distArr = new int[pointCnt][pointCnt]; // 시점, 물건, 종점 간의 최단거리

        for (int i = 0; i < pointCnt; i++) {
            bfs(i);
        }

        int minMove = Integer.MAX_VALUE;
        int itemCnt = itemList.size();
        int[] visitOrder = new int[itemCnt];
        for (int i = 0; i < itemCnt; i++) visitOrder[i] = i + 1;

        do {
            int curMove = 0;
            int prevIdx = 0;

            for (int i = 0; i < itemCnt; i++) {
                curMove += distArr[prevIdx][visitOrder[i]];
                prevIdx = visitOrder[i];
            }

            curMove += distArr[prevIdx][pointCnt - 1];

            minMove = Math.min(minMove, curMove);
        } while (nextPermutation(visitOrder));

        System.out.println(minMove);
    }

    static void bfs(int startIdx) {
        int[] start = points.get(startIdx);
        int[][] visited = new int[M][N];
        for (int[] row : visited) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] != '#' && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < points.size(); i++) {
            int[] target = points.get(i);
            distArr[startIdx][i] = visited[target[0]][target[1]];
        }
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--; // 오름차순이 깨지는 지점 찾기
        if (i <= 0) return false; // arr[0] 까지 오름차순이 유지되는 경우 다음 순열은 없음

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) j--; // 교환할 큰 값 찾기

        int temp = arr[i - 1]; // 두 값 교환
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) { // i 부터 끝까지 배열 뒤집기 -> 이전 순열 보다 큰 수 중 '가장 작은 수' 만들기
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}