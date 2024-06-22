import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < N-1; i++) {
            if (input[i] == 'E' && input[i+1] == 'W') result++;
        }

        System.out.println(result);
    }
}