import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long cntA = Long.parseLong(st.nextToken());
        long priceA = Long.parseLong(st.nextToken());
        long cntB = Long.parseLong(st.nextToken());
        long priceB = Long.parseLong(st.nextToken());

        // 가성비 비교(가성비 좋은 쪽이 B)
        if (priceA * cntB < priceB * cntA) {
            long temp = cntB;
            cntB = cntA;
            cntA = temp;
            temp = priceB;
            priceB = priceA;
            priceA = temp;
        }

        long result = Long.MAX_VALUE;
        boolean flag = false;

        for (int a = 0; a < cntB; a++) {
            long b = (long) Math.ceil((double)(n - a * cntA) / cntB);
            
            if (b < 0) {
                b = 0;
                flag = true;
            }

            result = Math.min(result, a * priceA + b * priceB);
            if (flag) break;
        }

        System.out.println(result);
    }
}