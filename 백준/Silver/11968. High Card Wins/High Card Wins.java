import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[2 * N + 1];
        int[] elsie = new int[N];

        for (int i = 0; i < N; i++) {
            elsie[i] = Integer.parseInt(br.readLine());
            used[elsie[i]] = true;
        }
        
        int[] bessie = new int[N];
        int idx = 0;
        for (int i = 1; i <= 2 * N; i++) {
            if (!used[i]) {
                bessie[idx++] = i;
            }
        }
        
        Arrays.sort(elsie);
        Arrays.sort(bessie);
        
        int e = 0;  
        int b = 0; 
        int point = 0;

        while (e < N && b < N) {
            if (bessie[b] > elsie[e]) {
                point++;
                e++;
                b++;
            } else {
                b++;
            }
        }

        System.out.println(point);
    }
}
