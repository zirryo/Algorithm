import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int initialMood = sc.nextInt();

        double[][] transition = new double[2][2];
        transition[0][0] = sc.nextDouble();
        transition[0][1] = sc.nextDouble();
        transition[1][0] = sc.nextDouble();
        transition[1][1] = sc.nextDouble();

        double[] mood = new double[2];
        mood[initialMood] = 1.0;

        for (int day = 0; day < N; day++) {
            double[] next = new double[2];
            for (int from = 0; from < 2; from++) {
                for (int to = 0; to < 2; to++) {
                    next[to] += mood[from] * transition[from][to];
                }
            }
            mood = next;
        }

        System.out.println(Math.round(mood[0] * 1000));
        System.out.println(Math.round(mood[1] * 1000));
    }
}
