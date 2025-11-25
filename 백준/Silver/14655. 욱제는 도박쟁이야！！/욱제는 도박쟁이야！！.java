import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.readLine();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(Integer.parseInt(st.nextToken()));
        }

        System.out.println(ans * 2);
    }
}
