import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int count = 0;
            int current = i;

            while (!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1; 
                count++;
            }

            sizes.add(count);
        }

        if (sizes.size() < 2) {
            return 0;
        }

        sizes.sort(Collections.reverseOrder());

        return sizes.get(0) * sizes.get(1);
    }
}