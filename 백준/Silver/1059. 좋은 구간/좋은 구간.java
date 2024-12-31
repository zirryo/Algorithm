import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        Arrays.sort(S);
        for (int num : S) {
            if (num == n) {
                System.out.println(0);
                return;
            }
        }

        int L_bound = 0, R_bound = 0;
        for (int i = 0; i < L; i++) {
            if (S[i] < n) {
                L_bound = S[i];
            } else {
                R_bound = S[i];
                break;
            }
        }

        int left = n - L_bound - 1; // 왼쪽 구간 수
        int right = R_bound - n - 1; // 오른쪽 구간 수
        int result = left + right + (left * right); // 왼 + 오 + n포함 중간구간 

        System.out.println(result);
    }
}
