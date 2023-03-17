import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, result = 100 * 50;
    static int[][] arr;
    static Cal[] calList;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        init();

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            calList[i] = new Cal(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }
        dfs(0, new boolean[K], new int[K]);
        System.out.println(result);
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        calList = new Cal[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    private static void dfs(int depth, boolean[] visited, int[] turnOrder) {
        if(depth == K) {
            turnArr(turnOrder);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            turnOrder[depth] = i;
            dfs(depth+1, visited, turnOrder);
            visited[i] = false;
        }
    }
    private static void turnArr(int[] turnOrder) {
        int[][] turnedArr = copy();
        for(int i=0; i<K; i++) {
            int r = calList[turnOrder[i]].r;
            int c = calList[turnOrder[i]].c;
            int S = calList[turnOrder[i]].s;

            for(int s=1; s<=S; s++) { // 회전 반경
                int temp = turnedArr[r-s][c+s]; // 우상단 값 임시 저장
                for(int k=c+s; k>c-s; k--) {
                    turnedArr[r-s][k] = turnedArr[r-s][k-1];
                }
                int temp2 = turnedArr[r+s][c+s]; // 우하단 값 임시 저장
                for(int k=r+s; k>r-s; k--) {
                    turnedArr[k][c+s] = turnedArr[k-1][c+s];
                }
                turnedArr[r-s+1][c+s] = temp;
                int temp3 = turnedArr[r+s][c-s]; // 좌하단 값 임시 저장
                for(int k=c-s; k<c+s; k++) {
                    turnedArr[r+s][k] = turnedArr[r+s][k+1];
                }
                turnedArr[r+s][c+s-1] = temp2;
                for(int k=r-s; k<r+s; k++) {
                    turnedArr[k][c-s] = turnedArr[k+1][c-s];
                }
                turnedArr[r+s-1][c-s] = temp3;
            }
        }
        getMin(turnedArr);
    }
    private static int[][] copy() {
        int[][] tempArr = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        return tempArr;
    }
    private static void getMin(int[][] resultArr) {
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += resultArr[i][j];
            }
            result = Math.min(result, sum);
        }
    }
    private static class Cal {
        int r;
        int c;
        int s;

        public Cal(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}