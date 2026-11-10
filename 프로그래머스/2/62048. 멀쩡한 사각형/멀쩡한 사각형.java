class Solution {

    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        long gcdVal = gcd(W, H);
        return (W * H) - (W + H - gcdVal);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}