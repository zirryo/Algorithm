import java.io.*;
import java.util.*;

public class Main {
    static int[] correctAnswers = new int[10];
    static int[] selected = new int[10];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            correctAnswers[i] = Integer.parseInt(st.nextToken());
        }

        findWays(0, 0);
        System.out.println(result);
    }

    static void findWays(int index, int score) {
        if (index == 10) {
            if (score >= 5) {
                result++;
            }
            return;
        }

        for (int choice = 1; choice <= 5; choice++) {
            if (index >= 2 && selected[index - 1] == choice && selected[index - 2] == choice) {
                continue;
            }

            selected[index] = choice;
            findWays(index + 1, score + (choice == correctAnswers[index] ? 1 : 0));
        }
    }
}
