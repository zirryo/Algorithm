import java.util.*;

public class Main {
    static class Star {
        int x, y;
        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int K = sc.nextInt();

        Star[] stars = new Star[K];
        for (int i = 0; i < K; i++) {
            stars[i] = new Star(sc.nextInt(), sc.nextInt());
        }

        int maxCount = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int baseX = stars[i].x;
                int baseY = stars[j].y;

                int count = 0;
                for (int k = 0; k < K; k++) {
                    if (baseX <= stars[k].x && stars[k].x <= baseX + L &&
                            baseY <= stars[k].y && stars[k].y <= baseY + L) {
                        count++;
                    }
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(K - maxCount);
    }
}
