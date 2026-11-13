class Solution {

    public int[] solution(int n, int m) {
        int gcdValue = gcd(n, m);
        int lcmValue = (n / gcdValue) * m;

        return new int[]{gcdValue, lcmValue};
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}