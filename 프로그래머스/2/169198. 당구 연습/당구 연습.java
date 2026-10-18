class Solution {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int min = Integer.MAX_VALUE;

            if (!(startY == targetY && startX > targetX)) {
                int dist = getDist(startX, startY, -targetX, targetY);
                min = Math.min(min, dist);
            }

            if (!(startY == targetY && startX < targetX)) {
                int dist = getDist(startX, startY, 2 * m - targetX, targetY);
                min = Math.min(min, dist);
            }

            if (!(startX == targetX && startY > targetY)) {
                int dist = getDist(startX, startY, targetX, -targetY);
                min = Math.min(min, dist);
            }

            if (!(startX == targetX && startY < targetY)) {
                int dist = getDist(startX, startY, targetX, 2 * n - targetY);
                min = Math.min(min, dist);
            }

            answer[i] = min;
        }

        return answer;
    }

    private int getDist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}