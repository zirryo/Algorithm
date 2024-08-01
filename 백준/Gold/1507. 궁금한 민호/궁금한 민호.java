import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] dist = new int[N][N];
        int[][] original = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = scanner.nextInt();
                original[i][j] = dist[i][j];
            }
        }

        scanner.close();

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        original[i][j] = 0;
                    }
                }
            }
        }

        int totalLength = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                totalLength += original[i][j];
            }
        }

        System.out.println(totalLength);
    }
}
