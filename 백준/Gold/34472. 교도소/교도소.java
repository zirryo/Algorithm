import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        int perRoom = total / N;
        int result = 0;
        int moving = 0;

        for (int i = 0; i < N; i++) {
            if (a[i] > perRoom) {
                moving += (a[i] - perRoom);
                a[i] = perRoom;
            } else if (a[i] < perRoom && moving > 0) {
                moving -= (perRoom - a[i]);
                a[i] = perRoom;
            }

            result += moving;
        }

        for (int i = 0; i < N; i++) {
            if (a[i] > perRoom) {
                moving += (a[i] - perRoom);
            } else if (a[i] < perRoom) {
                moving -= (perRoom - a[i]);
            }

            if (moving == 0) break;

            result += moving;
        }

        System.out.println(result);


    }
}