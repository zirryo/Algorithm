import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =1 ; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        int curSpeed = 0;

        for (int i = N ; i >= 1 ; i--) {
            curSpeed = Math.min(curSpeed + 1, arr[i]);
            sum += curSpeed;
        }

        System.out.println(sum);
    }
}
