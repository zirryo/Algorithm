import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int target;
    static int[] arr;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[4];
        arr = new int[]{1, 1, 1, 1};
        set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        target = getClockNum(input);
        dfs(0);
        System.out.println(set.size());
    }
    private static int getClockNum(int[] arr) {
        int res = 9999; // 최대 시계수는 9999
        for (int i = 0; i < 4; i++) {
            int temp = 0;
            for (int j = 3, k = i; j >= 0; j--, k++) {
                temp += arr[k%4] * Math.pow(10, j);
            }

            if (res > temp) res = temp;
        }
        return res;
    }
    private static void dfs(int depth) {
        if (depth == 4) {
            int tempCLK = getClockNum(arr);
            if (tempCLK <= target) set.add(tempCLK);
        } else {
            for (int i = 1; i <= 9; i++) {
                arr[depth] = i;
                dfs(depth + 1);
            }
        }
    }
}
