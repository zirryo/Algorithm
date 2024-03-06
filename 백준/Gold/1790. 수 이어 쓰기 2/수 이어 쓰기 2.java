import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // 한자리수 9개, 두자리수 90개, 세자리수 900개, ...n자리수 9 * 10^(n-1)

        long len = 1; // 자리수
        long cnt = 9; // 각 자리수별 수

        while (K > len * cnt) {
            K -= len * cnt;
            len++;
            cnt *= 10;
        }

        K--; // 0, 10, 100, ... 에서 시작하도록 조정
        long target = (long) Math.pow(10, len - 1) + (K / len);

        if (target > N) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(target).charAt((int)(K % len)));
        }
    }
}