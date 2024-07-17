import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[10];
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int[] fruit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = 1;
        int max = 1;
        cnt[fruit[left]]++;
        set.add(fruit[left]);

        while (right < N) {
            if (set.size() >= 2 && !set.contains(fruit[right])) {
                while (true) {
                    cnt[fruit[left]]--;
                    left++;
                    if (cnt[fruit[left-1]] == 0) {
                        set.remove(fruit[left-1]);
                        break;
                    }
                }
            }
            set.add(fruit[right]);
            cnt[fruit[right]]++;
            max = Math.max(max, right - left + 1);
            right++;
        }

        System.out.print(max);
    }
}