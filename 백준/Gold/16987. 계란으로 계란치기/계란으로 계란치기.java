import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static int[] S, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        findMaxCnt(0, 0);
        System.out.println(result);
    }
    private static void findMaxCnt(int inHand, int destroy) {
        if (inHand == N) { // 가장 오른쪽 계란을 든 경우
            result = Math.max(result, destroy);
            return;
        }

        if (S[inHand] <= 0 || destroy == N - 1) { // 깨진 계란을 든 경우 or 다른 계란이 이미 다 깨진 경우
            findMaxCnt(inHand + 1, destroy);
            return;
        }

        for (int target = 0; target < N; target++) {
            if (target == inHand) continue; // 타겟과 손에 든 계란 일치 (통과)
            if (S[target] <= 0) continue; // 타겟이 이미 깨짐 (통과)

            int temp = destroy;
            S[target] -= W[inHand];
            S[inHand] -= W[target];
            if (S[inHand] <= 0) temp++;
            if (S[target] <= 0) temp++;
            findMaxCnt(inHand + 1, temp);
            S[target] += W[inHand];
            S[inHand] += W[target];
        }
    }
}