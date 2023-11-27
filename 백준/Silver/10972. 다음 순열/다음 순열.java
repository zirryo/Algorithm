import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation()) {
            for (int i : arr) sb.append(i).append(" ");
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }
    private static boolean nextPermutation() {
        int desc = N - 1; // 내림차순이 시작되는 인덱스
        while (desc > 0 && arr[desc - 1] >= arr[desc]) {
            desc--;
        }
        if (desc == 0) return false;

        int swapTarget = N - 1; // 다음 순열을 만들기 위해 자리를 바꿀 타겟
        while (arr[desc - 1] >= arr[swapTarget]) {
            swapTarget--;
        }

        swapNums(desc - 1, swapTarget);
        swapTarget = N - 1; // desc 번째 인덱스부터 끝까지 오름차순으로 정렬

        while (desc < swapTarget) {
            swapNums(desc, swapTarget);
            desc++;
            swapTarget--;
        }

        return true;
    }
    private static void swapNums(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
