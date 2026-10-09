class Solution {

    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long pValue = Long.parseLong(p); 

        for (int i = 0; i <= t.length() - pLen; i++) {
            String subStr = t.substring(i, i + pLen);
            long subValue = Long.parseLong(subStr);

            if (subValue <= pValue) {
                answer++;
            }
        }

        return answer;
    }
}