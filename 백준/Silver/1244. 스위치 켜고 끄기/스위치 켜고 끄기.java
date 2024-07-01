import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] switches = new int[N];

        for (int i = 0; i < N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남학생
                for (int j = num - 1; j < N; j += num) {
                    switches[j] = 1 - switches[j]; // 반전
                }
            } else { // 여학생
                int left = num - 2;
                int right = num;
                switches[num - 1] = 1 - switches[num - 1]; // 중심 스위치 반전
                while (left >= 0 && right < N && switches[left] == switches[right]) {
                    switches[left] = 1 - switches[left];
                    switches[right] = 1 - switches[right];
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}