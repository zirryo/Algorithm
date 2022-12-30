import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int x, y; // 주사위의 좌표
    static int[] dice; // 1-윗면 2-뒷면 3-오른쪽면 4-왼쪽면 5-앞면 6-바닥
    static int[][] roll = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 동->서->남->북
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new int[7];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while(K-- >0) {
            int command = Integer.parseInt(st.nextToken());
            playDice(x, y, command);
        }
        System.out.println(sb);
    }

    private static void playDice(int r, int c, int command) {
        int tempX = x + roll[command-1][0];
        int tempY = y + roll[command-1][1];

        if(!inRange(tempX, tempY)) {
            return;
        }
        else {
            x = tempX;
            y = tempY;
            int temp = dice[1];

            switch (command) {
                case 1: { // 동
                    dice[1] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = temp;
                    break;
                }

                case 2: { // 서
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = temp;
                    break;
                }
                case 3: { // 남
                    dice[1] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = temp;
                    break;
                }
                case 4: { // 북
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = temp;
                    break;
                }
            }

            if(map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice[1]).append("\n");
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

}