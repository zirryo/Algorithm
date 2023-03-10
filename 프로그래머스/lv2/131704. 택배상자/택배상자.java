import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> assist = new Stack<>();
        for (int i = 1; i <= order.length; i++) { // 컨베이어벨트
            if(order[idx] != i) {
                assist.push(i);
            } else {
                idx++;
                answer++;
                while (!assist.isEmpty() && assist.peek() == order[idx]) {
                    assist.pop();
                    idx++;
                    answer++;
                }
            }
        }
        return answer;
    }
}