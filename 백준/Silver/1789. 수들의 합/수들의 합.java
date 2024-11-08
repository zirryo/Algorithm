import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int count = 0;
        int number = 1;

        while (sum + number <= S) {
            sum += number;
            number++;
            count++;
        }

        System.out.println(count);
    }
}
