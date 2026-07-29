class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }

        long n = num;
        int count = 0;

        while (n != 1 && count < 500) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }

        return n == 1 ? count : -1;
    }
}