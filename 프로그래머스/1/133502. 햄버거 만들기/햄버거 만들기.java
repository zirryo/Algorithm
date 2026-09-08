class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int top = 0; 
        int answer = 0;

        for (int ing : ingredient) {
            stack[top++] = ing; 

            if (top >= 4) {
                if (stack[top - 4] == 1 && 
                    stack[top - 3] == 2 && 
                    stack[top - 2] == 3 && 
                    stack[top - 1] == 1) {
                    
                    answer++;
                    top -= 4; 
                }
            }
        }

        return answer;
    }
}