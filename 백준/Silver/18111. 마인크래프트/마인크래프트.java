import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int maxFloor = 0;
        int minFloor = 256;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxFloor = Math.max(maxFloor, map[i][j]);
                minFloor = Math.min(minFloor, map[i][j]);
            }
        }
        int time = Integer.MAX_VALUE;
        int floor = 0;

        for(int k=maxFloor; k>=minFloor; k--) {
            int tempTime = 0;
            int blocks = B;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] < k) {
                        tempTime += (k - map[i][j]);
                        blocks -= (k - map[i][j]);
                    } else if (map[i][j] > k) {
                        tempTime += ((map[i][j] - k) * 2);
                        blocks += (map[i][j] - k);
                    }
                }
            }
            if(blocks < 0) continue;
            if(tempTime < time) {
                time = tempTime;
                floor = k;
            }
        }
        System.out.println(time + " " + floor);
    }
}