import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p1 = sc.nextInt();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int p2 = sc.nextInt();

        int totalP = p1 + p2;
        int totalS = s1 + s2;

        if (totalP > totalS) {
            System.out.println("Persepolis");
        } else if (totalP < totalS) {
            System.out.println("Esteghlal");
        } else {
            if (p2 > s1) {
                System.out.println("Persepolis");
            } else if (p2 < s1) {
                System.out.println("Esteghlal");
            } else {
                System.out.println("Penalty");
            }
        }

        sc.close();
    }
}
