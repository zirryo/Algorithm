import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] words;
    static int[] charToDigit; // 알파벳 -> 숫자 매핑
    static boolean[] usedDigit; // 숫자 사용 여부
    static boolean[] isLeading; // 맨 앞자리 여부 (0 사용 불가)
    static int maxLen;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("0")) break;

            try {
                N = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                break;
            }

            if (N == 0) break;

            words = new String[N];
            maxLen = 0;

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine().trim();
                maxLen = Math.max(maxLen, words[i].length());
            }
            
            charToDigit = new int[26];
            Arrays.fill(charToDigit, -1);
            usedDigit = new boolean[10];
            isLeading = new boolean[26];

            for (String s : words) {
                if (s.length() > 1) {
                    isLeading[s.charAt(0) - 'A'] = true;
                }
            }

            answer = 0;
            dfs(0, 0, 0, 0);

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }

    static void dfs(int col, int row, int currentSum, int carry) {
        if (col == maxLen) {
            if (carry == 0) answer++;
            return;
        }

        if (row == N - 1) {
            int total = currentSum + carry;
            int digit = total % 10;    
            int nextCarry = total / 10; // 다음 자리로 넘어갈 수

            int wordLen = words[row].length();
            int charIdx = wordLen - 1 - col; 

            if (charIdx >= 0) { // 결과 단어의 해당 자리에 문자가 있는 경우
                int ch = words[row].charAt(charIdx) - 'A';

                if (charToDigit[ch] != -1) { // 이미 할당된 알파벳인 경우 -> 계산 일치 확인
                    if (charToDigit[ch] == digit) {
                        dfs(col + 1, 0, 0, nextCarry);
                    }
                } else { // 할당되지 않은 알파벳인 경우 -> digit을 할당할 수 있는지 확인
                    if (!usedDigit[digit]) {
                        if (digit == 0 && isLeading[ch]) return; 

                        usedDigit[digit] = true;
                        charToDigit[ch] = digit;

                        dfs(col + 1, 0, 0, nextCarry);

                        // Backtracking
                        charToDigit[ch] = -1;
                        usedDigit[digit] = false;
                    }
                }
            } else {
                if (digit == 0) {
                    dfs(col + 1, 0, 0, nextCarry);
                }
            }
            return;
        }
        
        int wordLen = words[row].length();
        int charIdx = wordLen - 1 - col;

        if (charIdx < 0) {
            dfs(col, row + 1, currentSum, carry);
            return;
        }

        int ch = words[row].charAt(charIdx) - 'A';
        if (charToDigit[ch] != -1) { // 이미 할당된 경우
            dfs(col, row + 1, currentSum + charToDigit[ch], carry);
        } else { // 할당되지 않은 경우 0~9 시도
            for (int d = 0; d <= 9; d++) {
                if (usedDigit[d]) continue;
                if (d == 0 && isLeading[ch]) continue;

                usedDigit[d] = true;
                charToDigit[ch] = d;

                dfs(col, row + 1, currentSum + d, carry);

                usedDigit[d] = false;
                charToDigit[ch] = -1;
            }
        }
    }
}