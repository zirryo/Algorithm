import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long curTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            long bridgeTime = curTime + B;

            long cycle = C + D;
            long remain = curTime % cycle;
            long wait = 0;

            if (remain >= C) {
                wait = cycle - remain;
            }

            long crossTime = curTime + A + wait;
            curTime = Math.min(bridgeTime, crossTime);
        }

        System.out.println(curTime);
    }
}