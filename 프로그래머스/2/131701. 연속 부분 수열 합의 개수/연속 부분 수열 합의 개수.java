import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += elements[(i + j) % n];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}