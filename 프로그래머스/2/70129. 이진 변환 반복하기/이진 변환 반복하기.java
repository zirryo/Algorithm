class Solution {
    public int[] solution(String s) {
        int transformCount = 0; 
        int zeroCount = 0;

        while (!s.equals("1")) {
            int len = s.length();
            
            int onesCount = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    onesCount++;
                }
            }

            zeroCount += (len - onesCount);
            s = Integer.toBinaryString(onesCount);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}