import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result = 100_001;
    static char[][] original;
    static char[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        original = new char[2][N];
        target = new char[N];
        original[0] = br.readLine().toCharArray();
        original[1] = original[0].clone();
        target = br.readLine().toCharArray();
        solve(0, original[0]);
        solve(1, original[1]);
        if(result == 100001) System.out.println(-1);
        else System.out.println(result);
    }
    private static void solve(int fir, char[] arr) {
        int cnt = 0;
        if(fir == 1) {
            cnt++;
            arr[0] = (arr[0] == '0') ? '1' : '0';
            arr[1] = (arr[1] == '0') ? '1' : '0';
        }
        for(int i=1; i<N; i++) {
            if(arr[i-1] != target[i-1]) {
                onOff(i, arr);
                cnt++;
            }
        }
        if(arr[N-1] == target[N-1]) {
            result = Math.min(result, cnt);
        }
    }
    private static void onOff(int idx, char[] arr) {
        arr[idx-1] = (arr[idx-1] == '0') ? '1' : '0';
        arr[idx] = (arr[idx] == '0') ? '1' : '0';
        if(idx+1 < N) arr[idx+1] = (arr[idx+1] == '0') ? '1' : '0';
    }
}