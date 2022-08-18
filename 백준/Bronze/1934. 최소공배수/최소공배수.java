// 두 수의 최소공배수 -> 두 수를 곱하고 최대공약수로 나눈다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = getGCD(x,y);
            sb.append(x*y / z).append("\n");
        }
        System.out.println(sb);


    }
    // 최대 공약수를 구하는 메서드
    public static int getGCD(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if(max%min==0) return min;
        return getGCD(min, max%min);

    }
}