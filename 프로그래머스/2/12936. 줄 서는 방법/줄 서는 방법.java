import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> people = new ArrayList<>(n);

        long factorial = 1L;
        for (int i = 1; i <= n; i++) {
            people.add(i);
            factorial *= i;
        }

        k--;
        
        for (int i = 0; i < n; i++) {
            factorial /= (n - i); 
            int selectedIndex = (int) (k / factorial);

            answer[i] = people.remove(selectedIndex);
            k %= factorial;
        }

        return answer;
    }
}