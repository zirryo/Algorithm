// 최대공약수를 활용하는 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int base = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(N-- > 1) {
            int temp = Integer.parseInt(st.nextToken());
            int gcd = getGCD(base, temp);
            sb.append(base/gcd + "/" + temp/gcd + "\n");
        }
        System.out.println(sb);

    }
    static int getGCD(int x, int y) {
        int max = Math.max(x,y);
        int min = Math.min(x,y);

        if(max%min == 0) return min;
        return getGCD(min, max%min);
    }
}