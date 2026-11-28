class Solution {

    private int[][] answer;
    private int moveIndex;

    public int[][] solution(int n) {
        int totalMoves = (1 << n) - 1;
        answer = new int[totalMoves][2];
        moveIndex = 0;
        hanoi(n, 1, 2, 3);

        return answer;
    }

    private void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            answer[moveIndex][0] = from;
            answer[moveIndex][1] = to;
            moveIndex++;
            return;
        }

        hanoi(n - 1, from, to, via);

        answer[moveIndex][0] = from;
        answer[moveIndex][1] = to;
        moveIndex++;

        hanoi(n - 1, via, from, to);
    }
}