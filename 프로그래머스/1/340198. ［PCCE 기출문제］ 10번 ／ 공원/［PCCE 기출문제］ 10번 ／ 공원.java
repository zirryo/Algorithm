import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        int rows = park.length;
        int cols = park[0].length;

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            if (canPlace(size, park, rows, cols)) {
                return size; 
            }
        }

        return -1; 
    }

    private boolean canPlace(int size, String[][] park, int rows, int cols) {
        if (size > rows || size > cols) {
            return false;
        }

        for (int r = 0; r <= rows - size; r++) {
            for (int c = 0; c <= cols - size; c++) {
                if (isAllEmpty(park, r, c, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAllEmpty(String[][] park, int startR, int startC, int size) {
        for (int r = startR; r < startR + size; r++) {
            for (int c = startC; c < startC + size; c++) {
                if (!park[r][c].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}