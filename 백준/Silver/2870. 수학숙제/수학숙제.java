import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder number = new StringBuilder();

            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    number.append(ch);
                } else {
                    if (number.length() > 0) {
                        numbers.add(trimLeadingZeros(number.toString()));
                        number.setLength(0);
                    }
                }
            }

            if (number.length() > 0) {
                numbers.add(trimLeadingZeros(number.toString()));
            }
        }

        Collections.sort(numbers, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }

    private static String trimLeadingZeros(String num) {
        int idx = 0;
        while (idx < num.length() && num.charAt(idx) == '0') {
            idx++;
        }
        return idx == num.length() ? "0" : num.substring(idx);
    }
}