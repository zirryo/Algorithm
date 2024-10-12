import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int min = Math.abs(A - B);
        
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            min = Math.min(min, Math.abs(X - B) + 1);
        }
        
        System.out.println(min);
    }
}
