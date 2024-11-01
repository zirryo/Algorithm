import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int[][] NUM_DISPLAY = { // 7 - digit 으로 변환
            {1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 1, 0}, // 1
            {1, 0, 1, 1, 1, 0, 1}, // 2
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 1, 0}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {1, 0, 1, 0, 0, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}  // 9
    };

    static int s;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        s = Integer.parseInt(inputs[0]);
        n = inputs[1];

        StringBuilder[] lcd = new StringBuilder[2 * s + 3];
        for (int i = 0; i < lcd.length; i++) {
            lcd[i] = new StringBuilder();
        }

        for (char ch : n.toCharArray()) {
            int digit = ch - '0';
            buildDigit(lcd, digit);
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder line : lcd) {
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }

    private static void buildDigit(StringBuilder[] lcd, int digit) {
        int width = s + 2;
        int height = 2 * s + 3;
        
        // 윗 부분 (가로)
        appendHorizontal(lcd[0], NUM_DISPLAY[digit][0]);
        
        // 윗 부분 (세로 - 왼쪽, 오른쪽)
        for (int i = 1; i <= s; i++) {
            appendVertical(lcd[i], NUM_DISPLAY[digit][1], NUM_DISPLAY[digit][2]);
        }
        
        // 중간 부분 (가로)
        appendHorizontal(lcd[s + 1], NUM_DISPLAY[digit][3]);
        
        // 아랫 부분 (세로 - 왼쪽, 오른쪽)
        for (int i = s + 2; i < height - 1; i++) {
            appendVertical(lcd[i], NUM_DISPLAY[digit][4], NUM_DISPLAY[digit][5]);
        }
        
        // 아랫 부분 (가로)
        appendHorizontal(lcd[height - 1], NUM_DISPLAY[digit][6]);

        // 각 숫자 사이의 공백 생성
        for (int i = 0; i < height; i++) {
            lcd[i].append(" ");
        }
    }

    private static void appendHorizontal(StringBuilder sb, int isOn) {
        if (isOn == 1) {
            sb.append(" ");
            for (int i = 0; i < s; i++) sb.append("-");
            sb.append(" ");
        } else {
            for (int i = 0; i < s + 2; i++) sb.append(" ");
        }
    }

    private static void appendVertical(StringBuilder sb, int left, int right) {
        sb.append(left == 1 ? "|" : " ");
        for (int i = 0; i < s; i++) sb.append(" ");
        sb.append(right == 1 ? "|" : " ");
    }
}
