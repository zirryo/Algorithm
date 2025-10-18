import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] possibleJobCnt = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            possibleJobCnt[x]++;
        }

        int[] need = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(need);

        boolean result = true;

        for (int i = M; i > 0; i--) {
            if (need[i] > possibleJobCnt[i]) {
                result = false;
                break;
            } else if (need[i] < possibleJobCnt[i]) {
                possibleJobCnt[i-1] += (possibleJobCnt[i] - need[i]);
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}