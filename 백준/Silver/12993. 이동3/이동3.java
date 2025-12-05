import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long S = x + y;
        long T = 2 * S + 1; // 등비수열의 합 공식을 이용

        long tmp = T;
        while (tmp % 3 == 0) tmp /= 3;
        if (tmp != 1) { // 3의 거듭제곱 형태인지 확인
            System.out.println(0);
            return;
        }
        
        while (x > 0 || y > 0) {
            int a = (int)(x % 3);
            int b = (int)(y % 3);

            if (a + b > 1) {  // 3진수로 변환한다고 가정했을 때, 같은 자릿수에서 동시에 1이 되면 안됨
                System.out.println(0);
                return;
            }

            x /= 3;
            y /= 3;
        }

        System.out.println(1);
    }
}
