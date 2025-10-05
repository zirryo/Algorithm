import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            int money = Integer.parseInt(line);
            if (money == -1) break;
            sum += money;
        }

        System.out.println(sum);
    }
}
