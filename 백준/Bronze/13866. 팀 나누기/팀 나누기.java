import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int diff1 = Math.abs((A + B) - (C + D));
        int diff2 = Math.abs((A + C) - (B + D));
        int diff3 = Math.abs((A + D) - (B + C));

        int answer = Math.min(diff1, Math.min(diff2, diff3));
        System.out.println(answer);
    }
}
