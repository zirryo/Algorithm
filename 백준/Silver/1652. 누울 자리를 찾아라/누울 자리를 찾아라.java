import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];

        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int horizontalCount = 0;
        int verticalCount = 0;

        for (int i = 0; i < N; i++) {
            int emptySpace = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    emptySpace++;
                } else {
                    if (emptySpace >= 2) {
                        horizontalCount++;
                    }
                    emptySpace = 0;
                }
            }
            if (emptySpace >= 2) {
                horizontalCount++;
            }
        }
        for (int j = 0; j < N; j++) {
            int emptySpace = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    emptySpace++;
                } else {
                    if (emptySpace >= 2) {
                        verticalCount++;
                    }
                    emptySpace = 0;
                }
            }
            if (emptySpace >= 2) {
                verticalCount++;
            }
        }

        System.out.println(horizontalCount + " " + verticalCount);
    }
}
