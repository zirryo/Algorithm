import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            cards.add(i);
            cards.add(i);
        }

        cards.remove((Integer) A);
        cards.remove((Integer) B);

        int win = 0;
        int total = 0;

        int myScore = getScore(A, B);

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                int C = cards.get(i);
                int D = cards.get(j);

                int enemyScore = getScore(C, D);

                if (myScore > enemyScore) win++;
                total++;
            }
        }

        double winProb = (double) win / total;
        System.out.printf("%.3f\n", winProb);
    }

    public static int getScore(int x, int y) {
        if (x == y) return x + 100; // 땡
        return (x + y) % 10; // 끗
    }
}
