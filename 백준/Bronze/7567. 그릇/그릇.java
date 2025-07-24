import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dishes = br.readLine();
        
        int height = 10;
        for (int i = 1; i < dishes.length(); i++) {
            if (dishes.charAt(i) == dishes.charAt(i - 1)) {
                height += 5;
            } else {
                height += 10;
            }
        }

        System.out.println(height);
    }
}
