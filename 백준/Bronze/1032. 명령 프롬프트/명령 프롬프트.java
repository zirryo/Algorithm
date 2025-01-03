import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        char[] result = pattern.toCharArray();

        for (int i = 1; i < n; i++) {
            String fileName = br.readLine();
            for (int j = 0; j < result.length; j++) {
                if (result[j] != fileName.charAt(j)) {
                    result[j] = '?';
                }
            }
        }

        System.out.println(new String(result));
    }
}
