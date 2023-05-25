import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, x;
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        selectQuestion();
        System.out.println(result);
    }
    private static void selectQuestion() {
        // 브루트 포스로 0000 0000 0000 0000 ~ 0111 1111 1111 1111 까지 조합 탐색
        ArrayList<Integer> list;
        for (int k = 0; k < (1 << n); k++) {
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((1 << i & k) != 0) {
                    list.add(arr[i]);
                }
            }

            if (isValid(list)) result++;
        }
    }
    private static boolean isValid(ArrayList<Integer> arrayList) {
        // 1. 두 문제 이상
        if (arrayList.size() < 2) return false;

        // 2. 문제 난이도 합은 l 이상, r 이하
        int sum = 0;
        for (int num : arrayList) sum += num;
        if (sum < l || sum > r) return false;

        // 3. 최대 난이도 - 최소 난이도 >= x
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - 1) - arrayList.get(0) >= x;
    }
}