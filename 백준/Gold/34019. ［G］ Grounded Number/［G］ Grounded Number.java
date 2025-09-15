import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if (N % 2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
