import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        sc.close();

        int result = 0;

        if (input.contains("x")) {
            int xIndex = input.indexOf("x");
            String coeffStr = input.substring(0, xIndex);

            if (coeffStr.isEmpty()) {
                result = 1;
            } else if (coeffStr.equals("-")) {
                result = -1;
            } else {
                result = Integer.parseInt(coeffStr);
            }
        }

        System.out.println(result);
    }
}
