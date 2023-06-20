import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
    }
    private static String solve() {
        if (N == 1) return "A";
        else if (N == 2) {
            if (arr[0] == arr[1]) return String.valueOf(arr[0]);
            else return "A";
        }

        int a,b;

        if (arr[0] == arr[1]) { // 0으로 나누는 것을 방지하기 위함
            a = 1;
            b = 0;
        } else {
            a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
            b = arr[1] - (arr[0] * a);
        }

        if (isValid(a, b)) {
            int nextNum = arr[N-1] * a + b;
            return String.valueOf(nextNum);
        } else return "B";
    }
    private static boolean isValid(int a, int b) {
        for (int i=1; i < N-1; i++) {
            if (arr[i+1] == (arr[i] * a + b)) continue;
            return false;
        }
        return true;
    }
}