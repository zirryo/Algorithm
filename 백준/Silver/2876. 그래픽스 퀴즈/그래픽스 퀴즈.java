import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] desk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        desk = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            desk[i][0] = Integer.parseInt(st.nextToken());
            desk[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        int answerGrade = 6; 

        for (int grade = 1; grade <= 5; grade++) {
            int count = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                if (desk[i][0] == grade || desk[i][1] == grade) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }

            if (max > maxCount || (max == maxCount && grade < answerGrade)) {
                maxCount = max;
                answerGrade = grade;
            }
        }

        System.out.println(maxCount + " " + answerGrade);
    }
}
