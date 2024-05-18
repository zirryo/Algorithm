import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int heartX = -1, heartY = -1;
        // Heart 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    heartX = i + 1;
                    heartY = j;
                    break;
                }
            }
            if (heartX != -1) break;
        }

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;
        // 왼쪽 팔, 오른쪽 팔 길이 계산
        for (int j = heartY - 1; j >= 0 && map[heartX][j] == '*'; j--) {
            leftArm++;
        }
        for (int j = heartY + 1; j < N && map[heartX][j] == '*'; j++) {
            rightArm++;
        }

        // 허리 길이 계산
        for (int i = heartX + 1; i < N && map[i][heartY] == '*'; i++) {
            waist++;
        }

        // 다리 길이 계산
        int legStart = heartX + waist + 1;
        for (int i = legStart; i < N; i++) {
            if (map[i][heartY - 1] == '*') leftLeg++;
            if (map[i][heartY + 1] == '*') rightLeg++;
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
