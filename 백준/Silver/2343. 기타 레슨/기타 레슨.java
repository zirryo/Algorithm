import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int start = 0;
    static int end = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 강의 수
        M = Integer.parseInt(st.nextToken()); // 블루레이 수
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.max(start, arr[i]);
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = blueRay(mid);

            if(cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
    private static int blueRay(int mid) {
        int sum = 0;
        int cnt = 0;

        for(int i=0; i<N; i++) {
            if(sum + arr[i] > mid) {
                sum = 0;
                cnt++;
            }
            sum += arr[i];
        }

        if(sum != 0) cnt++;
        return cnt;
    }

}