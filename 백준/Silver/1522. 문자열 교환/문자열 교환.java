import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        int aCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }

        String doubledString = s + s;
        int minSwap = Integer.MAX_VALUE;
        int currentBCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (doubledString.charAt(i) == 'b') {
                currentBCount++;
            }
        }

        minSwap = currentBCount;
        for (int i = 1; i < n; i++) {
            if (doubledString.charAt(i - 1) == 'b') {
                currentBCount--;
            }
            if (doubledString.charAt(i + aCount - 1) == 'b') {
                currentBCount++;
            }
            minSwap = Math.min(minSwap, currentBCount);
        }

        System.out.println(minSwap);
    }
}
