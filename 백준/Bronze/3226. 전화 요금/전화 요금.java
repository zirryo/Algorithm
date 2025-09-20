import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int DAY_START = 7 * 60;   
    static final int DAY_END = 19 * 60;   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int totalCost = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " :");
            int HH = Integer.parseInt(st.nextToken());
            int MM = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());

            int start = HH * 60 + MM;

            for (int d = 0; d < duration; d++) {
                int cur = (start + d) % (24 * 60);
                if (cur >= DAY_START && cur < DAY_END) {
                    totalCost += 10;
                } else {
                    totalCost += 5;
                }
            }
        }

        System.out.println(totalCost);
    }
}
