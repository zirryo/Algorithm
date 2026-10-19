class Solution {

    public int solution(String name) {
        int length = name.length();
        int upDownCount = 0;
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);

            upDownCount += Math.min(ch - 'A', 'Z' - ch + 1);

            int nextIdx = i + 1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            int move1 = i * 2 + (length - nextIdx);
            int move2 = (length - nextIdx) * 2 + i;

            minMove = Math.min(minMove, Math.min(move1, move2));
        }

        return upDownCount + minMove;
    }
}