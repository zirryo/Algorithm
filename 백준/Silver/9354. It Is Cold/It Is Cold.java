import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String firstLine = br.readLine();
        int tc = Integer.parseInt(firstLine);

        while (tc-- > 0) {
            String nLine = br.readLine();
            int N = Integer.parseInt(nLine);

            long[] speeds = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                speeds[i] = Long.parseLong(st.nextToken());
            }

            String dirInput = br.readLine();
            char[] dirs = new char[N];
            int idx = 0;
            for (int i = 0; i < dirInput.length(); i++) {
                char c = dirInput.charAt(i);
                if (c == 'T' || c == 'A') {
                    dirs[idx++] = c;
                }
            }

            long totalSpeed = 0L;
            boolean isValid = false;

            for (int i = N - 1; i >= 0; i--) {
                if (!isValid) {
                    if (dirs[i] == 'T') {
                        isValid = true;
                        totalSpeed += speeds[i];
                    }
                } else {
                    if (dirs[i] == 'T') {
                        totalSpeed += speeds[i];
                    } else {
                        totalSpeed -= speeds[i];
                        if (totalSpeed < 0) totalSpeed = 0;
                    }
                }
            }

            sb.append(Math.max(0, totalSpeed)).append("\n");
        }
        System.out.println(sb);
    }
}