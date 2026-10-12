class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int targetLen = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < cur && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(cur);
        }

        return sb.substring(0, targetLen);
    }
}