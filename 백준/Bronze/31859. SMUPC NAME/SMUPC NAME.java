import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();

        StringBuilder unique = new StringBuilder();
        boolean[] seen = new boolean[26];
        int discarded = 0;

        for (char c : S.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                unique.append(c);
            } else {
                discarded++;
            }
        }

        unique.append(discarded + 4);
        String step3 = (N + 1906) + unique.toString();
        String reversed = new StringBuilder(step3).reverse().toString();
        String result = "smupc_" + reversed;

        System.out.println(result);
    }
}
