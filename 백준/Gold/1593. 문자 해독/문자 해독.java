import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wLen = Integer.parseInt(st.nextToken());
        int sLen = Integer.parseInt(st.nextToken());

        String W = br.readLine();
        String S = br.readLine();

        int[] targetFreq = new int[52];
        int[] currentFreq = new int[52];

        for (int i = 0; i < wLen; i++) {
            targetFreq[getIdx(W.charAt(i))]++;
        }

        // S 탐색 전, W에 등장하지 않는 문자열은 일치하는 것으로 판정
        int correctChars = 0;
        for (int i = 0; i < 52; i++) {
            if (targetFreq[i] == 0) correctChars++;
        }

        int result = 0;

        for (int i = 0; i < sLen; i++) {
            int in = getIdx(S.charAt(i));
            currentFreq[in]++;

            if (currentFreq[in] == targetFreq[in]) {
                correctChars++;
            } else if (currentFreq[in] == targetFreq[in] + 1) {
                correctChars--;
            }

            if (i >= wLen) {
                int out = getIdx(S.charAt(i - wLen));
                currentFreq[out]--;

                if (currentFreq[out] == targetFreq[out]) {
                    correctChars++;
                } else if (currentFreq[out] == targetFreq[out] - 1) {
                    correctChars--;
                }
            }

            if (correctChars == 52) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int getIdx(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        else return c - 'a' + 26;
    }
}