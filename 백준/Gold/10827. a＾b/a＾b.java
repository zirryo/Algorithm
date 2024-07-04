import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        BigDecimal a = new BigDecimal(input[0]); // 내부적으로 십진수 저장하여 무한한 정밀도 보장
        int b = Integer.parseInt(input[1]);

        System.out.println(a.pow(b).toPlainString()); // 불필요한 0 제거 -> 문자열로 변환
    }
}
