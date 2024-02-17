import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 초기 수분
        int a = Integer.parseInt(st.nextToken()); // 물을 주는 화분의 수
        int b = Integer.parseInt(st.nextToken()); // 물을 주는 양

        int day = 0;
        int cycle = 0;

        while (true) {
            day++;
            if (day % (n/a) == 0) cycle++;
            if (k - day + cycle * b <= 0) break;
        }

        System.out.println(day);
    }
}