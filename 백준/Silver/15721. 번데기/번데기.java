import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int T = sc.nextInt();
        int targetType = sc.nextInt();

        int targetCount = 0;
        int totalTurn = 0;
        int n = 1;

        while (true) {

            int[] base = {0, 1, 0, 1};
            for (int type : base) {
                if (type == targetType) targetCount++;
                totalTurn++;
                if (targetCount == T) {
                    System.out.println((totalTurn - 1) % A);
                    return;
                }
            }

            for (int i = 0; i < n + 1; i++) {
                if (targetType == 0) targetCount++;
                totalTurn++;
                if (targetCount == T) {
                    System.out.println((totalTurn - 1) % A);
                    return;
                }
            }

            for (int i = 0; i < n + 1; i++) {
                if (targetType == 1) targetCount++;
                totalTurn++;
                if (targetCount == T) {
                    System.out.println((totalTurn - 1) % A);
                    return;
                }
            }

            n++;
        }
    }
}