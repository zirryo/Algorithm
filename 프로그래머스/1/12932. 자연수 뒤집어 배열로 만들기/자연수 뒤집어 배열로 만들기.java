class Solution {

    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        int index = 0;
        while (n > 0) {
            answer[index++] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }
}