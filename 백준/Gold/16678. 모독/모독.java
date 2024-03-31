import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        long result = 0L;
        int curHonor = 1;
        Arrays.sort(score);

        for (int i = 0; i < N; i++) {
            if (score[i] < curHonor) continue;
            result += score[i] - curHonor;
            score[i] = curHonor++;

        }
        System.out.println(result);
    }
}