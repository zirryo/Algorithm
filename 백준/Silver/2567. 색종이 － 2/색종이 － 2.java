import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[][] paper = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int dx = 0; dx < 10; dx++) {
                for (int dy = 0; dy < 10; dy++) {
                    paper[x + dx][y + dy] = true;
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (paper[i][j]) {
                    if (!paper[i-1][j]) result++; // 상
                    if (!paper[i+1][j]) result++; // 하
                    if (!paper[i][j-1]) result++; // 좌
                    if (!paper[i][j+1]) result++; // 우
                }
            }
        }

        System.out.println(result);
    }
}