import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            
            for (int j = 0; j < count; j++) {
                left.append(i);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(left)
              .append("0")
              .append(left.reverse());
              
        return answer.toString();
    }
}