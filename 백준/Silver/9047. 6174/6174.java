import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(kaprekarRoutine(n)).append("\n");
        }

        System.out.print(sb);
    }

    private static int kaprekarRoutine(int n) {
        int count = 0;
        while (n != 6174) {
            String[] digits = String.format("%04d", n).split("");
            Arrays.sort(digits);
            
            int ascending = Integer.parseInt(String.join("", digits));
            int descending = Integer.parseInt(new StringBuilder(String.join("", digits)).reverse().toString());

            n = descending - ascending;
            count++;
        }
        return count;
    }
}

/* Kaprekar's routine
- 4자리 숫자를 내림차순과 오름차순으로 정렬한 뒤 그 차를 계산하는 방식.
- 4자리 숫자 조합에 대하여 최악의 경우는 7번.
 */
