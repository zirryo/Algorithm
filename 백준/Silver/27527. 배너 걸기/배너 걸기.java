import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int K = (int) Math.ceil((double) 9 * M / 10);

        int[] heightFreq = new int[1000001]; // 높이에 따른 빈도
        int[] freqOfFreq = new int[M + 1]; // 빈도수 자체의 빈도

        int maxFreq = 0;
        boolean possible = false;

        for (int i = 0; i < N; i++) {
            int in = A[i];
            freqOfFreq[heightFreq[in]]--;
            heightFreq[in]++;
            freqOfFreq[heightFreq[in]]++;

            if (heightFreq[in] > maxFreq) {
                maxFreq = heightFreq[in];
            }

            if (i >= M) {
                int out = A[i - M];
                if (heightFreq[out] == maxFreq && freqOfFreq[maxFreq] == 1) {
                    maxFreq--;
                }
                freqOfFreq[heightFreq[out]]--;
                heightFreq[out]--;
                freqOfFreq[heightFreq[out]]++;
            }

            if (i >= M - 1) {
                if (maxFreq >= K) {
                    possible = true;
                    break;
                }
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
}