import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mushrooms = new int[10];
        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int prev = sum;
            sum += mushrooms[i];

            if (sum >= 100) {
                if (Math.abs(sum - 100) < Math.abs(prev - 100)) {
                    System.out.println(sum);
                } else if (Math.abs(sum - 100) > Math.abs(prev - 100)) {
                    System.out.println(prev);
                } else { 
                    System.out.println(Math.max(sum, prev));
                }
                return;
            }
        }
        
        System.out.println(sum);
    }
}
