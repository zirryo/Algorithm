// 소인수분해 후 2*5의 개수를 찾아야 하며,
// 항상 2의 개수가 더 많으므로 5의 개수만 카운트
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        if(x>=5) count = count + x/5;
        if(x>=25) count = count + x/25;
        if(x>=125) count = count + x/125;
        System.out.println(count);

    }
}