import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int totalTime = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int X = 0, Y = 0;
        int prevTime = 0;
        int dirIdx = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            X += dx[dirIdx] * (time - prevTime);
            Y += dy[dirIdx] * (time - prevTime);

            prevTime = time;

            if (dir.equals("left")) {
                dirIdx = (dirIdx + 1) % 4;
            } else if (dir.equals("right")) {
                dirIdx = (dirIdx + 3) % 4;
            }
        }

        X += dx[dirIdx] * (totalTime - prevTime);
        Y += dy[dirIdx] * (totalTime - prevTime);


        System.out.println(X + " " + Y);
    }
}
