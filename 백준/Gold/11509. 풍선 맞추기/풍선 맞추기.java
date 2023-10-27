import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] balloon = new int[1000002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (balloon[h+1] > 0) balloon[h+1]--;
            balloon[h]++;
        }

        int result = 0;
        for (int i = 0; i < balloon.length; i++) {
            result += balloon[i];
        }

        System.out.println(result);
    }
}