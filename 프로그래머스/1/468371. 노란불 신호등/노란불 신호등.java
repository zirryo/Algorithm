class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] T = new int[n];
        long maxTime = 1;

        for (int i = 0; i < n; i++) {
            T[i] = signals[i][0] + signals[i][1] + signals[i][2];
            maxTime = lcm(maxTime, T[i]);
        }

        for (int t = 1; t <= maxTime; t++) {
            boolean allYellow = true;

            for (int i = 0; i < n; i++) {
                int offset = (t - 1) % T[i];
                int G = signals[i][0];
                int Y = signals[i][1];

                if (offset < G || offset >= G + Y) {
                    allYellow = false;
                    break; 
                }
            }

            if (allYellow) {
                return t;
            }
        }

        return -1;
    }

    private long gcd(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}