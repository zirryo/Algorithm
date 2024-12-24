import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int idx = 0;
        int N = 0;

        while (idx < input.length()) {
            N++;
            String cur = Integer.toString(N);

            for (int i = 0; i < cur.length(); i++) {
                if (idx < input.length() && cur.charAt(i) == input.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(N);
    }
}