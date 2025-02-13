import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int half = Integer.parseInt(br.readLine()) / 2;
        int[][] count = new int[26][2];

        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < half; i++) {
            count[input[i] - 'a'][0]++;
        }

        for (int i=input.length-half; i < input.length; i++) {
            count[input[i] - 'a'][1]++;
        }

        for (int i = 0; i < 26; i++) {
            if ((count[i][0] + count[i][1]) % 2 != 0) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}