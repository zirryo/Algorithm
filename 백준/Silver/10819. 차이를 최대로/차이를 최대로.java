import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int N;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        isVisited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        getDiff(0, 0, arr, 0);
        System.out.println(result);
    }

    private static void getDiff(int cnt, int sum, int[] arr, int temp) {
        if(cnt == N) {
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            if (cnt == 0) getDiff(cnt + 1, sum, arr, i);
            else {
                int x = Math.abs(arr[i] - arr[temp]);
                getDiff(cnt + 1, sum + x, arr, i);
            }
            isVisited[i] = false;
        }
    }

}

