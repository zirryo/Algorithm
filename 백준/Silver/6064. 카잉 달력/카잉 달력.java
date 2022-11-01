import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = getGCD(M, N);
            int lcm = getLCM(gcd, M, N);

            int i = 0;
            int result = -1;

            while(M * i < lcm) {
                if((M * i + x - y) % N == 0) {
                    result = M * i + x;
                    break;
                }
                i++;
            }
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
    private static int getGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max%min==0) return min;
        return getGCD(max%min, min);
    }

    private static int getLCM(int gcd, int a, int b) {
        return (a*b / gcd);
    }

}