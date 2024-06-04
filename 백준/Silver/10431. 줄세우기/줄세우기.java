import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            height = new int[20];
            for (int j = 0; j < 20; j++) {
                height[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(num + " " + compareHeight() + "\n");
        }
        System.out.println(sb);
    }
    private static int compareHeight() {
        int cnt = 0;
        for (int i = 1; i < 20; i++) {
            int target = height[i];
            int j = i - 1;
            while (j >= 0 && height[j] > target) {
                height[j+1] = height[j];
                j--;
                cnt++;
            }
            height[j+1] = target;
        }
        return cnt;
    }
}