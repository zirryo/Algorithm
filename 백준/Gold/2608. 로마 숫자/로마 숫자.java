import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Character, Integer> map = new HashMap<>();
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roman1 = sc.nextLine();
        String roman2 = sc.nextLine();
        sc.close();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num1 = romanToInt(roman1);
        int num2 = romanToInt(roman2);
        int sum = num1 + num2;

        String romanSum = intToRoman(sum);
        System.out.println(sum + "\n" + romanSum);
    }

    private static int romanToInt(String s) {
        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur < prev) {
                total -= cur;
            } else {
                total += cur;
            }
            prev = cur;
        }
        return total;
    }

    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}