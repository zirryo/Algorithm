import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long totalMeals = 0;
        long totalWaste = 0;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            int k = A / X; 
            totalMeals += k;
            long waste = A - 1L * k * Y;
            if (waste < 0) waste = 0;
            totalWaste += waste;
        }

        System.out.println(totalMeals);
        System.out.println(totalWaste);
    }
}
