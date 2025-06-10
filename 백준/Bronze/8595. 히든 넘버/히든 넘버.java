import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        long result = 0L;

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(input[i])) {
                int val = Character.getNumericValue(input[i]);
                while (++i < len) {
                    if (Character.isDigit(input[i])) {
                        val *= 10;
                        val += Character.getNumericValue(input[i]);
                    } else break;
                }
                result += val;
            }
        }

        System.out.println(result);
    }
}