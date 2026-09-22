class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);
        int nextNumber = n + 1;

        while (true) {
            if (Integer.bitCount(nextNumber) == targetCount) {
                return nextNumber;
            }
            nextNumber++;
        }
    }
}