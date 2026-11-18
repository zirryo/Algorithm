class Solution {

    public String solution(int n) {
        String[] digits = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            sb.append(digits[remainder]);

            if (remainder == 0) {
                n = (n / 3) - 1;
            } else {
                n /= 3;
            }
        }

        return sb.reverse().toString();
    }
}