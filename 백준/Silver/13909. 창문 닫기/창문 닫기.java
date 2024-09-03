import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        
        // N 이하의 완벽한 제곱수의 개수를 구한다
        long result = (long)Math.sqrt(N);
       
        System.out.println(result);
    }
}
