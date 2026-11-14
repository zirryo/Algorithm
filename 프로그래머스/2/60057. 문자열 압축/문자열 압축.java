class Solution {

    public int solution(String s) {
        int n = s.length();
        int minLength = n;

        for (int step = 1; step <= n / 2; step++) {
            minLength = Math.min(minLength, compress(s, n, step));
        }

        return minLength;
    }

    private int compress(String s, int n, int step) {
        int len = 0;
        String prev = s.substring(0, step);
        int count = 1;

        for (int i = step; i <= n - step; i += step) {
            String current = s.substring(i, i + step);

            if (prev.equals(current)) {
                count++;
            } else {
                len += step + (count > 1 ? getCount(count) : 0);
                prev = current;
                count = 1;
            }
        }

        len += step + (count > 1 ? getCount(count) : 0);
        len += n % step;

        return len;
    }

    private int getCount(int count) {
        if (count < 10) return 1;
        if (count < 100) return 2;
        if (count < 1000) return 3;
        return 4;
    }
}