class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder valid = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.indexOf(c) == -1) {
                valid.append(c);
            }
        }

        String validChars = valid.toString();
        int validLen = validChars.length();
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            int curIdx = validChars.indexOf(c);
            int newIdx = (curIdx + index) % validLen;
            answer.append(validChars.charAt(newIdx));
        }

        return answer.toString();
    }
}