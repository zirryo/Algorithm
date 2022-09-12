import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[][] wire;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wire = new int[N][2];
        dp = new int[N]; // 인덱스까지 교차없이 설치 가능한 전깃줄의 최대 개수를 저장하는 배열

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() { // A 전봇대를 기준으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<N; i++) {
            dp[i] = 1; // 최솟값이 1
            for(int j=0; j<i; j++) {
                if(wire[i][1] > wire[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max); // 전체 전깃줄 수 - 교차 없이 가능한 최대 전깃줄 수 = 최소 제거

    }
}