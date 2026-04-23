import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int gap1 = b - a - 1;
            int gap2 = c - b - 1;

            System.out.println(Math.max(gap1, gap2));
        }
    }
}