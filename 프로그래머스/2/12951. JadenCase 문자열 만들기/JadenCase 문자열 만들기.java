class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                isFirst = true;
            } else {
                if (isFirst) {
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        return sb.toString();
    }
}