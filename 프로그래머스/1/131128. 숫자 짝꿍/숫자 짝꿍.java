class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int digit = 9; digit >= 0; digit--) {
            int commonCount = Math.min(countX[digit], countY[digit]);
            for (int i = 0; i < commonCount; i++) {
                sb.append(digit);
            }
        }

        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}