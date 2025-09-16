import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = sc.next().toCharArray();
        }

        int[] result = new int[5];

        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                int crash = 0;
                boolean building = false;

                Loop:
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        char c = map[i + x][j + y];
                        if (c == '#') {
                            building = true;
                            break Loop;
                        } else if (c == 'X') {
                            crash++;
                        }
                    }
                }

                if (!building) {
                    result[crash]++;
                }
            }
        }

        for (int k = 0; k <= 4; k++) {
            System.out.println(result[k]);
        }
    }
}
