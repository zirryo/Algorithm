class Solution {

    public int[] solution(String[] wallpaper) {
        int rows = wallpaper.length;
        int cols = wallpaper[0].length();

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    lux = Math.min(lux, r);
                    luy = Math.min(luy, c);
                    rdx = Math.max(rdx, r + 1);
                    rdy = Math.max(rdy, c + 1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}