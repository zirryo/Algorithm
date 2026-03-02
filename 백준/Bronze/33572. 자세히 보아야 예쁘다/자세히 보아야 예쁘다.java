import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long maxTime = 0;
        st = new StringTokenizer(br.readLine());

        boolean isPossible = false;
        for (int i = 0; i < N; i++) {
            long time = Long.parseLong(st.nextToken());
            maxTime += (time - 1);

            if (maxTime >= M) {
                isPossible = true;
                break;
            }
        }

        if (isPossible) {
            System.out.println("DIMI");
        } else {
            System.out.println("OUT");
        }
    }
}