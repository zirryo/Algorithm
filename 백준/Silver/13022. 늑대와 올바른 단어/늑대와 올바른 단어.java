import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        if (wolf(arr)) System.out.println(1);
        else System.out.println(0);
    }
    private static boolean wolf(char[] input) {
        int cnt = 0;
        char[] wolf = {'o', 'l', 'f'};

        if (input[input.length-1] == 'w') return false;

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (c == 'w') {
                cnt++;
            } else {
                if (cnt <= 0) {
                    return false;
                }
                for (int j = 0; j <= 2; j++) {
                    for (int k = 0; k < cnt; k++) {
                        if (i + cnt * j + k >= input.length || input[i + cnt * j + k] != wolf[j]) {
                            return false;
                        }
                    }
                }
                i += cnt * 3 - 1;
                cnt = 0;
            }
        }
        return true;
    }
}