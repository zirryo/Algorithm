import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] brand = new int[51];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            brand[x]++;
        }

        long result = 0L;
        long prev = 1L;

        for (int i = 1; i <= 50; i++) {
            if (brand[i] == 0) break;

            prev *= brand[i];
            result += prev;
        }

        System.out.println(result);
    }
}