import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int[] limit = new int[100]; 
        int[] speed = new int[100]; 

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int maxSpeed = Integer.parseInt(st.nextToken());

            for (int j = 0; j < length; j++) {
                limit[idx++] = maxSpeed;
            }
        }

        idx = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int driveSpeed = Integer.parseInt(st.nextToken());

            for (int j = 0; j < length; j++) {
                speed[idx++] = driveSpeed;
            }
        }

        int maxOverSpeed = 0;
        for (int i = 0; i < 100; i++) {
            maxOverSpeed = Math.max(maxOverSpeed, speed[i] - limit[i]);
        }

        System.out.println(maxOverSpeed);
    }
}
