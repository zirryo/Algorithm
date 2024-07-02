import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        Arrays.sort(input, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    int sum1 = getDigitSum(o1);
                    int sum2 = getDigitSum(o2);
                    
                    if (sum1 != sum2) {
                        return sum1 - sum2;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
            private int getDigitSum(String input) {
                int sum = 0;
                for(char c : input.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += Character.getNumericValue(c);
                    }
                }
                return sum;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}