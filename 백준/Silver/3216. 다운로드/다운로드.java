import java.io.*;

public class Main {
    static int N;
    static int[] D, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        D = new int[N];
        V = new int[N];

        long totalDownload = 0;

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            D[i] = Integer.parseInt(tokens[0]);
            V[i] = Integer.parseInt(tokens[1]);
            totalDownload += V[i];
        }

        long left = 0;
        long right = totalDownload;
        long answer = totalDownload;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canPlay(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canPlay(long T) {
        long downloadTime = 0;
        long playTime = T;

        for (int i = 0; i < N; i++) {
            downloadTime += V[i];
            if (downloadTime > playTime) {
                return false;
            }
            playTime += D[i];
        }

        return true;
    }
}
