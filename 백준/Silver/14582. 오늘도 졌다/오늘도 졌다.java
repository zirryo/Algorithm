import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[][] score = new int[2][9];
        for (int i = 0; i < 9; i++) {
            score[0][i] = Integer.parseInt(st.nextToken());
            score[1][i] = Integer.parseInt(st1.nextToken());
        }

        int total1 = 0;
        int total2 = 0;
        boolean flag = false;

        for (int i = 0; i < 9; i++) {
            total1 += score[0][i];
            if (total1 > total2 && !flag) flag = true;
            total2 += score[1][i];
        }

        if (flag && total2 > total1) System.out.println("Yes");
        else System.out.println("No");

        // 240426 Hanwha Eagles 6 losing streak
    }
}