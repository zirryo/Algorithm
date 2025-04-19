import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int junwon = Integer.parseInt(st.nextToken());
        int[] others = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            others[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(others); 

        long cur = junwon;
        for (int power : others) {
            if (cur <= power) {
                System.out.println("No");
                return;
            }
            cur += power;
        }

        System.out.println("Yes");
    }
}
