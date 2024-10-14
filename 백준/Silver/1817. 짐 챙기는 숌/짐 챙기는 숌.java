import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        int[] book = new int[N];
        for (int i = 0; i < N; i++) {
            book[i] = Integer.parseInt(st.nextToken());
        }
        
        int box = 1;
        int curWeight = 0;
        
        for (int w : book) {
            if (curWeight + w > M) {
                box++;
                curWeight = w;
            } else {
                curWeight += w;
            }
        }

        System.out.println(box);
    }
}
